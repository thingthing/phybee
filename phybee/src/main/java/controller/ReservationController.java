package controller;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import entity.Movie;
import entity.Schedule;
import entity.Ticket;
import service.DateService;
import service.MovieService;
import service.ReservationService;
import service.UserService;
import bean.DateScheduleBean;
import bean.UserBean;

@Controller
@RequestMapping(value="/reservation")
public class ReservationController {

	@Autowired
	private UserBean user;
	@Autowired
	private UserService userService;
	@Autowired
	private ReservationService reservationService;
	@Autowired
	private MovieService movieService;
	
	
	@RequestMapping(value="/movie", method=RequestMethod.GET)
	public ModelAndView chooseMovieAndDate(
			@RequestParam(value = "movie", required = false, defaultValue = "") String movie,
			@RequestParam(value = "date", required = false, defaultValue = "") String date) throws ParseException {
		System.out.println("Book, firstStep");

		List<Movie> movies = movieService.getCurrentMovies();
		List<DateScheduleBean> schedule = null;

		if (!movie.isEmpty() || !date.isEmpty()) {
			try
			{
				if (!movie.isEmpty() && !date.isEmpty())
					schedule = reservationService.getScheduleInfo(Integer.parseInt(movie), DateService.parseDate(date, "yyyy-MM-dd"));
				else if (!movie.isEmpty())
					schedule = reservationService.getScheduleInfoWithFilmId(Integer.parseInt(movie));
			} catch (NoResultException e)
			{
				System.out.println("No schedule found");
			}
		}
		
		ModelAndView mv = new ModelAndView("bookFirstStep");
		mv.addObject("movie", movie);
		mv.addObject("movies", movies);
		mv.addObject("date", date);
		if (user == null || user.getId() == null)
		{
			try
			{
				userService.login(user);
			} catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		mv.addObject("user", user);
		if (schedule != null && schedule.size() > 0)
			mv.addObject("schedule", schedule);
		return mv;
	}
	
	@RequestMapping("/ticket")
	public ModelAndView chooseTicket(
			@RequestParam(value = "schedule", required = true) String scheduleId,
			@RequestParam(value = "error", required = false, defaultValue="") String error) {
		System.out.println("Book, secondStep");

		Schedule schedule = reservationService.getScheduleInfo(Integer.parseInt(scheduleId));
		Movie movie = schedule.getMovie();
		
		List<Ticket> ticket = reservationService.getTicketInfo();
		
		ModelAndView mv = new ModelAndView("bookSecondStep");
		mv.addObject("movie", movie);
		mv.addObject("schedule", schedule);
		mv.addObject("ticket", ticket);
		mv.addObject("error", error);
		if (user == null || user.getId() == null)
		{
			try
			{
				userService.login(user);
			} catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		mv.addObject("user", user);
		return mv;
	}
	
	@RequestMapping("/validation")
	public ModelAndView seeSummary(
			@RequestParam(value = "schedule", required = true) String scheduleId,
			@RequestParam(value = "Adult", required = true) String adult,
			@RequestParam(value = "Child", required = true) String child,
			@RequestParam(value = "Disabled", required = true) String disabled) {
		System.out.println("Book, thirdStep");

		double amount = 0.00;
	
		Schedule schedule = reservationService.getScheduleInfo(Integer.parseInt(scheduleId));
		Map<Ticket, Integer> basket = new HashMap<Ticket, Integer>();

		List<Ticket> ticket = reservationService.getTicketInfo();

		if (Integer.parseInt(adult) == 0 && Integer.parseInt(child) == 0 && Integer.parseInt(disabled) == 0) {
			return chooseTicket(scheduleId, "Error: Can't buy 0 tickets !");
		}
			
		
		for (Ticket t : ticket) {
			if (t.getType().equals("Adult"))
				basket.put(t, Integer.parseInt(adult));
			else if (t.getType().equals("Child"))
				basket.put(t, Integer.parseInt(child));
			else if (t.getType().equals("Disabled"))
				basket.put(t, Integer.parseInt(disabled));
		}
		
		for (Ticket key : basket.keySet()) {
			amount += basket.get(key) * key.getPrice();
		}
		
		NumberFormat format = java.text.NumberFormat.getCurrencyInstance(java.util.Locale.CHINA);
		DecimalFormatSymbols dfs = new DecimalFormatSymbols();
		dfs.setCurrencySymbol("¥");
		dfs.setGroupingSeparator('.');
		dfs.setMonetaryDecimalSeparator('.');
		((DecimalFormat) format).setDecimalFormatSymbols(dfs);
		
		ModelAndView mv = new ModelAndView("bookThirdStep");
		mv.addObject("schedule", schedule);
		mv.addObject("basket", basket);
		mv.addObject("amount", format.format(amount));
		mv.addObject("adult", adult);
		mv.addObject("child", child);
		mv.addObject("disabled", disabled);
		mv.addObject("user", user);
		return mv;
	}
	
	@RequestMapping("/redirection")
	public String validateReservation(
			@RequestParam(value = "schedule", required = true) String scheduleId,
			@RequestParam(value = "adult", required = true) int adult,
			@RequestParam(value = "child", required = true) int child,
			@RequestParam(value = "disabled", required = true) int disabled) {
		Integer userId = user.getId();
		System.out.println("Book, fourth user id is " + userId);
		
		if (userId <= 0)
		{
			return "redirect:/home";
		}
		reservationService.removeAvailableSeat(Integer.parseInt(scheduleId), adult + child, false);
		reservationService.removeAvailableSeat(Integer.parseInt(scheduleId), disabled, true);
		reservationService.setReservationInfo(adult, child, disabled, Integer.parseInt(scheduleId), userId);
		
		return "redirect:/profil";
	}
}

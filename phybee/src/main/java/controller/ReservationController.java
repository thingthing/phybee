package controller;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import service.DateService;
import service.MovieService;
import service.ReservationService;
import bean.MovieBean;
import bean.ScheduleBean;
import bean.TicketBean;

@Controller
public class ReservationController {

	@RequestMapping(value="/reservation/movie", method=RequestMethod.GET)
	public ModelAndView chooseMovieAndDate(
			@RequestParam(value = "movie", required = false, defaultValue = "") String movie,
			@RequestParam(value = "date", required = false, defaultValue = "") String date) throws ParseException {
		System.out.println("Book, firstStep");
 
		ReservationService res = new ReservationService();

		ArrayList<String>  movies = res.getFilmList();
		ArrayList<ScheduleBean> schedule = null;

		if (!movie.isEmpty() || !date.isEmpty()) {
			if (!movie.isEmpty() && !date.isEmpty())
				schedule = res.getScheduleInfo(movie, DateService.parseDate(date, "yyyy-MM-dd"));
			else if (!movie.isEmpty())
				schedule = res.getScheduleInfo(movie);
			else if (!date.isEmpty())
				schedule = res.getScheduleInfo(DateService.parseDate(date, "yyyy-MM-dd"));
		}
		
		ModelAndView mv = new ModelAndView("bookFirstStep");
		mv.addObject("movie", movie);
		mv.addObject("movies", movies);
		mv.addObject("date", date);
		if (schedule != null && schedule.size() > 0)
			mv.addObject("schedule", schedule);
		return mv;
	}
	
	@RequestMapping("/reservation/ticket")
	public ModelAndView chooseTicket(
			@RequestParam(value = "schedule", required = true) String scheduleId) {
		System.out.println("Book, secondStep");

		ReservationService res = new ReservationService();
		
		ScheduleBean schedule = res.getScheduleInfo(Integer.parseInt(scheduleId)).get(0);
		MovieBean movie = MovieService.getMovieInfo(schedule.getId_movie());
		List<TicketBean> ticket = res.getTicketInfo();
		
		ModelAndView mv = new ModelAndView("bookSecondStep");
		mv.addObject("movie", movie);
		mv.addObject("schedule", schedule);
		mv.addObject("ticket", ticket);
		return mv;
	}
	
	@RequestMapping("/reservation/validation")
	public ModelAndView seeSummary(
			@RequestParam(value = "schedule", required = true) String scheduleId,
			@RequestParam(value = "Adult", required = true) String adult,
			@RequestParam(value = "Child", required = true) String child,
			@RequestParam(value = "Disabled", required = true) String disabled) {
		System.out.println("Book, thirdStep");

		double amount = 0.00;
		
		ReservationService res = new ReservationService();
		
		ScheduleBean schedule = res.getScheduleInfo(Integer.parseInt(scheduleId)).get(0);
		Map<TicketBean, Integer> basket = new HashMap<TicketBean, Integer>();

		List<TicketBean> ticket = res.getTicketInfo();

		for (TicketBean t : ticket) {
			if (t.getType().equals("Adult"))
				basket.put(t, Integer.parseInt(adult));
			else if (t.getType().equals("Child"))
				basket.put(t, Integer.parseInt(child));
			else if (t.getType().equals("Disabled"))
				basket.put(t, Integer.parseInt(disabled));
		}
		
		for (TicketBean key : basket.keySet()) {
			amount += basket.get(key) * key.getPrice();
		}
		
		NumberFormat format = java.text.NumberFormat.getCurrencyInstance(java.util.Locale.CHINA);
		DecimalFormatSymbols dfs = new DecimalFormatSymbols();
		dfs.setCurrencySymbol("�");
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
		return mv;
	}
	
	@RequestMapping("/reservation/redirection")
	public ModelAndView validateReservation(
			@RequestParam(value = "schedule", required = true) String scheduleId,
			@RequestParam(value = "adult", required = true) int adult,
			@RequestParam(value = "child", required = true) int child,
			@RequestParam(value = "disabled", required = true) int disabled) {
		System.out.println("Book, fourth");
		
		ReservationService res = new ReservationService();
		//@todo: Add user id
		res.setReservationInfo(adult, child, disabled, Integer.parseInt(scheduleId), 1);
		
		ModelAndView mv = new ModelAndView("helloworld");
		return mv;
	}
}

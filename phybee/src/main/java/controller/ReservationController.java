package controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import service.DateService;
import service.ReservationService;
import bean.ScheduleBean;
import bean.TicketBean;

@Controller
public class ReservationController {

	@RequestMapping(value="/reservation/movie", method=RequestMethod.GET)
	public ModelAndView firstStep(
			@RequestParam(value = "movie", required = false, defaultValue = "") String movie,
			@RequestParam(value = "date", required = false, defaultValue = "") String date) throws ParseException {
		System.out.println("Book, firstStep");
 
		ReservationService res = new ReservationService();

		ArrayList<String>  movies = res.getFilmList();
		ArrayList<ScheduleBean> slot = null;

		if (!movie.isEmpty() || !date.isEmpty()) {
			if (!movie.isEmpty() && !date.isEmpty())
				slot = res.getScheduleInfo(movie, DateService.parseDate(date, "yyyy-MM-dd"));
			else if (!movie.isEmpty())
				slot = res.getScheduleInfo(movie);
			else if (!date.isEmpty())
				slot = res.getScheduleInfo(DateService.parseDate(date, "yyyy-MM-dd"));
		}
		
		ModelAndView mv = new ModelAndView("bookFirstStep");
		mv.addObject("movie", movie);
		mv.addObject("movies", movies);
		mv.addObject("date", date);
		if (slot != null && slot.size() > 0)
			mv.addObject("slot", slot);
		return mv;
	}
	
	@RequestMapping("/reservation/ticket")
	public ModelAndView secondStep(
			@RequestParam(value = "slot", required = true) String slot) {
		System.out.println("Book, secondStep");
		
//		String[] ticket = { "Adult", "Child", "Disabled" };

		ReservationService res = new ReservationService();
		
//		ScheduleBean schedule = res.getScheduleInfo(slot);
//		MovieBean movie = res.getMovieInfo(schedule.getId_movie());
		List<TicketBean> ticket = res.getTicketInfo();
		
		ModelAndView mv = new ModelAndView("bookSecondStep");
//		mv.addObject("movie", movie);
//		mv.addObject("slot", schedule);
		mv.addObject("ticket", ticket);
		return mv;
	}
	
	@RequestMapping("/reservation/validation")
	public ModelAndView thirdStep(
			@RequestParam(value = "slot", required = true) String slot,
			@RequestParam(value = "Adult", required = true) String adult,
			@RequestParam(value = "Child", required = true) String child,
			@RequestParam(value = "Disabled", required = true) String disabled) {
		System.out.println("Book, thirdStep");
		
		String[] payment = {"CB", "Alipay", "VISA"};
		double amount = 0.00;
		
		ReservationService res = new ReservationService();
		
//		ScheduleBean schedule = res.getScheduleInfo(slot);
		List<TicketBean> ticket = res.getTicketInfo();
		
		for (TicketBean t : ticket) {
			if (t.getType().equals("Adult"))
				t.setNumber(Integer.parseInt(adult));
			else if (t.getType().equals("Child"))
				t.setNumber(Integer.parseInt(child));
			else if (t.getType().equals("Disabled"))
				t.setNumber(Integer.parseInt(disabled));
			amount += t.getPrice() * t.getNumber();
		}
		
		ModelAndView mv = new ModelAndView("bookThirdStep");
//		mv.addObject("slot", schedule);
		mv.addObject("ticket", ticket);
		mv.addObject("amount", amount);
		mv.addObject("payment", payment);
		return mv;
	}
	
	@RequestMapping("/reservation/redirection")
	public ModelAndView fourthStep(
			@RequestParam(value = "slot", required = true) String slot,
			@RequestParam(value = "ticket", required = true) List<String> ticket,
			@RequestParam(value = "amount", required = true) double amount,
			@RequestParam(value = "payment", required = true) String payment) {
		System.out.println("Book, thirdStep");
		
		ModelAndView mv = new ModelAndView("helloworld");
		return mv;
	}
}

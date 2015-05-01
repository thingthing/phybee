package controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ReservationController {

	@RequestMapping("/reservation/movie")
	public ModelAndView firstStep(
			@RequestParam(value = "movie", required = false, defaultValue = "") String movie,
			@RequestParam(value = "date", required = false, defaultValue = "") String date) {
		System.out.println("Book, firstStep");
 
		String[] movies = { "Big hero 6", "Mon voisin Totoro", "Transformers",
		"One piece" };
		String[] dates = { "Monday", "Tuesday", "Wednesday", "Thursday",
		"Friday", "Saturday", "Sunday" };
		String[] slots = { "Big hero 6 VF 14:00 Thursday 18 101",
				"Transformers VO 18:25 Wednesday 19 102", "Mon voisin Totoro VO 12:25 Wednesday 19 102" };
		List<String> slot = new ArrayList<String>();

		if (!movie.isEmpty() || !date.isEmpty()) {
			
			
			for (String s : slots) {
				if (!movie.isEmpty() && !date.isEmpty()) {
					if (s.contains(movie) && s.contains(date)) { // if (slots.movie.equals(movie) &&
												// slots.date.equals(date))
						slot.add(s);
					}
				}

			}
		}
		
		ModelAndView mv = new ModelAndView("bookFirstStep");
		mv.addObject("movie", movie);
		mv.addObject("date", date);
		mv.addObject("movies", movies);
		mv.addObject("dates", dates);
		if (slot.size() > 0)
			mv.addObject("slot", slot);
		return mv;
	}
	
	@RequestMapping("/reservation/ticket")
	public ModelAndView secondStep(
			@RequestParam(value = "movie", required = true) String movie,
			@RequestParam(value = "slot", required = true) String slot) {
		System.out.println("Book, secondStep");
		
		String[] ticket = { "Adult", "Child", "Disabled" };

		ModelAndView mv = new ModelAndView("bookSecondStep");
		mv.addObject("slot", slot);
		mv.addObject("movie", movie);
		mv.addObject("ticket", ticket);
		return mv;
	}

}

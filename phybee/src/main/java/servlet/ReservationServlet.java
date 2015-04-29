package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ReservationServlet
 */
@WebServlet(name = "ReservationServlet", urlPatterns = "/reservation")
public class ReservationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReservationServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String slot = request.getParameter("slot");
		String movie = request.getParameter("movie");

		if (slot != null)
			secondStep(request, response);
		else
			firstStep(request, response);
	}

	protected void firstStep(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String movie = request.getParameter("movie");
		String date = request.getParameter("date");

		String[] movies = { "Big hero 6", "Mon voisin Totoro", "Transformers",
				"One piece" };
		String[] dates = { "Monday", "Tuesday", "Wednesday", "Thursday",
				"Friday", "Saturday", "Sunday" };

		request.setAttribute("movies", movies);
		request.setAttribute("dates", dates);
		request.setAttribute("movie", movie);
		request.setAttribute("date", date);

		if (movie != null || date == null) {

			/*
			 * Search for slots of the movie selected
			 */
			String[] slotsAva = { "Big hero 6 VF 14:00 Thursday 18 101",
					"Transformers VO 18:25 Wednesday 19 102", "Mon voisin Totoro VO 12:25 Wednesday 19 102" };
			List<String> slots = new ArrayList<String>();

			for (String s : slotsAva) {
				if (movie != null && date != null) {
					if (s.contains(movie) && s.contains(date)) { // if (slots.movie.equals(movie) &&
												// slots.date.equals(date))
						slots.add(s);
					}
				}

				if (slots.size() > 0)
					request.setAttribute("slots", slots);
			}
		}

		request.getRequestDispatcher("WEB-INF/jsp/view/bookFirstStep.jsp").forward(request,
				response);
	}

	protected void secondStep(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String slot = request.getParameter("slot");
		String movie = request.getParameter("movie");

		String[] ticket = { "Adult", "Child", "Disabled" };

		if (slot != null) {
			request.setAttribute("slot", slot);
			request.setAttribute("movie", movie);
			request.setAttribute("ticket", ticket);
			request.getRequestDispatcher("WEB-INF/jsp/view/bookSecondStep.jsp").forward(request,
					response);
		} else
			request.getRequestDispatcher("WEB-INF/jsp/view/bookFirstStep.jsp").forward(request,
					response);
	}
}

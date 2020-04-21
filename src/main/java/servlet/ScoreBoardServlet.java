package servlet;

import controller.PlayerDao;
import model.Player;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/")
public class ScoreBoardServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sort = req.getParameter("sort");
        PlayerDao dao = new PlayerDao();
        List<Player> playerList = dao.getAllScores(sort);
        req.setAttribute("players", playerList);
        req.getRequestDispatcher("/WEB-INF/scoreboard.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("name");
        long score = Long.parseLong(req.getParameter("score"));
        long defaultId = 1;
        Player player = new Player(defaultId, username, score);

        PlayerDao dao = new PlayerDao();
        if (dao.addNewScore(player)) {
            resp.sendRedirect("/");
        } else {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            resp.getWriter().print("not found");
        }
    }
}

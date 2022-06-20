import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DataAndTimeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String dataOrTime = request.getParameter("cmd");

        if (dataOrTime == null) {
            request.setAttribute("dataOrTime", "Параметр не указан");
        }
        else {
            switch (dataOrTime) {
                case "date":
                    request.setAttribute("dataOrTime", "Текущая дата: " + LocalDate.now().format(
                            DateTimeFormatter.ofPattern("dd.MM.yyyy")));
                    break;
                case "time":
                    request.setAttribute("dataOrTime", "Текущее время: " + LocalTime.now().format(
                            DateTimeFormatter.ofPattern("HH:mm:ss")));
                    break;
                default:
                    request.setAttribute("dataOrTime", "Параметр не корректен");
                    break;
            }
        }

        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}

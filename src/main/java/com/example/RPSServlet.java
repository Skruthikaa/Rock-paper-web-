package com.example;

import java.io.IOException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/play")
public class RPSServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String playerChoice = request.getParameter("choice");

        String[] choices = {"rock", "paper", "scissors"};
        String computerChoice = choices[(int) (Math.random() * choices.length)];

        String result;

        if (playerChoice.equals(computerChoice)) {
            result = "It's a Draw!";
        } else if (
                (playerChoice.equals("rock") && computerChoice.equals("scissors")) ||
                (playerChoice.equals("paper") && computerChoice.equals("rock")) ||
                (playerChoice.equals("scissors") && computerChoice.equals("paper"))
        ) {
            result = "You Win!";
        } else {
            result = "You Lose!";
        }

        response.setContentType("text/plain");
        response.getWriter().println("You chose: " + playerChoice);
        response.getWriter().println("Computer chose: " + computerChoice);
        response.getWriter().println(result);
    }
}

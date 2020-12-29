package com.laioffer.ProjectYu.servlet;

import com.laioffer.jupiter.entity.Item;
import com.laioffer.recommendation.ItemRecommender;
import com.laioffer.recommendation.RecommendationException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

@WebServlet(name = "RecommendationServlet", urlPatterns = {"/recommendation"})
public class RecommendationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false); //没有登陆也不创建session
        ItemRecommender itemRecommender = new ItemRecommender();
        Map<String, List<Item>> itemMap;
        try {
            if (session == null) {
                itemMap = itemRecommender.recommendItemsByDefault();
            } else {
                String userId = (String) request.getSession().getAttribute("user_id");
                itemMap = itemRecommender.recommendItemsByUser(userId);
            }
        } catch (RecommendationException e) {
            throw new ServletException(e);
        }
        ServletUtil.writeItemMap(response, itemMap);
    }
}

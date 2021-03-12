package org.comstudy21.myweb;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.comstudy21.myweb.board.BoardService;
import org.comstudy21.myweb.board.BoardVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
   @Autowired
   private DataSource dataSource;
   
   @Autowired
   SqlSession mybatis;
   
   @Autowired
   BoardService boardService;
   
   private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
   
   /**
    * Simply selects the home view to render by returning its name.
    */
   @RequestMapping(value = "/", method = RequestMethod.GET)
   public String home(Locale locale, Model model) {
      System.out.println(">>>>>>>>>>>>> dataSource : " + dataSource);
      System.out.println(">>>>>>>>>>>>> mybatis : " + mybatis);
      
      List<BoardVO> list = mybatis.selectList("BoardDAO.getBoardList1");
      for(BoardVO board : list) {
         System.out.println(board);
      }
      
      logger.info("Welcome home! The client locale is {}.", locale);
      
      Date date = new Date();
      DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
      
      String formattedDate = dateFormat.format(date);
      
      model.addAttribute("serverTime", formattedDate );
      
      return "home";
   }
   
}
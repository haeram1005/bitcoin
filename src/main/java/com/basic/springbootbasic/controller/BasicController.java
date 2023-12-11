package com.basic.springbootbasic.controller;

import com.basic.springbootbasic.domain.Board;
import com.basic.springbootbasic.service.BoardSerive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BasicController {

    //NOTE : service 생성
    @Autowired
    private BoardSerive boardSerive;

    // @GetMapping("/")
    // @ResponseBody
    // public String main(){

    //     return "Hello World";

    // }

    @GetMapping("/board/write")
    public String boardWriteForm(){

        return "boardwrite";

    }



//    @PostMapping("/board/writepro") NOTE : jpa를 활용해 entity 어노테이션을 이용하기 때문에 클래스 활용이 가능하다 때문에 현재 예제는 안써도됨
//    public String boardWritePro(String title, String content) {
//
//        System.out.println("제목 : " + title);
//        System.out.println("내용 : " + content);
//
//        return "";
//    }

    @PostMapping("/board/writepro")
    public String boardWritePro(Board board) {

        System.out.println("제목 : " + board.getTitle());
        System.out.println("내용 : " + board.getContent());

        boardSerive.BoardWrite(board);

        return "";
    }

    @GetMapping("/board/list")
    public String boardList(Model model){

        model.addAttribute("list",boardSerive.boardList());

        return "boardlist";
    }
    @GetMapping("/board/view")
    public String boardView(Model model , Integer id){

        model.addAttribute("board",boardSerive.boardView(id));

        return "boardview";
    }

}

package com.xinjingjie.picServer.controller;

import com.xinjingjie.picServer.bean.*;
import com.xinjingjie.picServer.impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@RestController
@RequestMapping("/api/pic/")
public class PicController {
    @Autowired
    private UserImpl userImpl;

    @Autowired
    private PicImpl picImpl;

    @Autowired
    private CommentImpl commentImpl;


    @Autowired
    private TagImpl tagImpl;

    @Autowired
    private LikeImpl likeImpl;
    @RequestMapping(value = "uploadFile")
    public JsonData upload(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
        String result = FileSaveUtil.getINSTANCE(userImpl, picImpl).saveFile(file, request, "PostImage");
        String tags = request.getParameter("tags");
        String[] split = tags.split("#");
        Set<String> linkedHashSet = new LinkedHashSet<>();
        for (String s: split) {
            System.out.println(s);
            if (s!=null){
            linkedHashSet.add(s);}
        }
        for (String tag:linkedHashSet){
            String t=tag;
        if (tagImpl.isExist(t)){
            tagImpl.insert(new Tag(t));
            }
        }

        if (!"success".equals(result)) {
            return new JsonData(-1, result);
        } else
            return new JsonData(0, result);
    }

    @GetMapping(value = "/getAll", produces = "application/json;charset=UTF-8")
    public TotalPics getALl(int uid) {
        // if (userImpl.isExist(uid)){
        System.out.println("i am here--------------------------");
        List<Picture> pictures = picImpl.getAllByUserId(uid);
        int total = picImpl.getCountById(uid);
        return new TotalPics(total, total, pictures);
        //   }else {
        //       return new JsonData(-1,"用户不存在！");
        //   }
    }

    @PostMapping("what")
    public String what(MultipartFile file, HttpServletRequest request) {
        System.out.println(request.getParameter("username"));
        System.out.println(request.getParameter("contents"));
        System.out.println(request.getParameter("tags"));
        //   System.out.println(username);
        System.out.println(file.getSize());
        System.out.println(file.getOriginalFilename());
        return "success";
    }

    @GetMapping(value = "getRecommend", produces = "application/json;charset=UTF-8")
    public TotalPics getPublic() {
        return new TotalPics(100, 20, new Random().nextBoolean() ? picImpl.getPicsByComments() : picImpl.getPicsByLikes());
    }

    @GetMapping(value = "getByContent", produces = "application/json;charset=UTF-8")
    public TotalPics getByContent(String key) {
        int total = picImpl.getCountByContent(key);
        int totalHits = 0;
        if (total < 20) {
            totalHits = total;
        } else {
            totalHits = 20;
        }
        return new TotalPics(total, totalHits, picImpl.getPicsByContent(key));
    }


/*
给图片点赞
 */
    @GetMapping(value = "addLike")
    public JsonData addLike(int pid,int user_id) {
        Like like=new Like(pid,user_id);
        if (picImpl.updateLikeNum(1,pid)!=0&&likeImpl.insert(like)!=0)
            return new JsonData(0,"success");
        else
            return new JsonData(-1,"failure");
    }
/*
取消给图片点赞
 */
//    @GetMapping(value = "reduceLike")
//    public JsonData reduceLike(int pid,int user_id) {
//        if (picImpl.updateLikeNum(-1,pid)!=0||likeImpl.delete(l_id)!=0)
//            return new JsonData(0,"success");
//        else
//            return new JsonData(-1,"failure");
//    }

    /**
     *
     * @param pid 图片id
     * @param uid 评论人id
     * @param content 评论内容
     * @return
     */
    @GetMapping(value = "addComments")
    public JsonData addComments(int pid,int uid,String username,String content) {
        Comment comment=new Comment(pid, uid, 0,0,new Date(),content, userImpl.findProfilePic(uid), username);
        if (picImpl.updateCommentsNum(1,pid)==1&&commentImpl.addComment(comment)==1)
            return new JsonData(0,"success");
        else
            return new JsonData(-1,"failure");
    }

    @GetMapping(value = "reduceComments")
    public JsonData reduceComments(int pid,int cid) {
        if (picImpl.updateCommentsNum(-1,pid)==1&&commentImpl.deleteComment(cid)==1)
            return new JsonData(0,"success");
        else
            return new JsonData(-1,"failure");
    }
}

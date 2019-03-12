package com.wzc.web.controller;

import com.wzc.bean.*;
import com.wzc.service.IAlbumService;
import com.wzc.service.IRelationMapService;
import com.wzc.service.IUploadFileService;
import com.wzc.service.IUserService;
import com.wzc.utils.JsonT;
import com.wzc.utils.ParamT;
import com.wzc.utils.StrT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class UserContoller {
    @Autowired
    private IUserService userService;

    @Autowired
    private IAlbumService albumService;

    @Autowired
    private IUploadFileService uploadFileService;

    @Autowired
    private IRelationMapService mapService;


    @RequestMapping("/f/profile/{userid}")//根据用户id跳转到用户的个人中心或个人主页
    public String profile(@PathVariable Integer userid, HttpServletRequest request,HttpServletResponse response) throws IOException {
        User loginUser = (User) request.getSession().getAttribute("loginUser");
        if(loginUser.getUserid().equals(userid)){
            //当前登陆人则跳转到个人中心
            request.setAttribute("user",loginUser);
            return "front/personal";
        }else{
            //否则跳转到用户主页
            User user = userService.selectByPrimaryKey(userid);
            if(user!=null){
                request.setAttribute("user",user);
                boolean isf =mapService.cheackRelationIsExist(loginUser.getUserid(),userid,"friend")>0;
                request.setAttribute("isFriend",isf);
                return "front/profile";
            }else {
                request.setAttribute("error","对不起，你访问的用户不存在或已被管理员删除。");
                return "front/error";
            }

        }
    }

    @RequestMapping("/f/edituserbase")//编辑用户基本信息
    public void usereditbase(HttpServletRequest request,HttpServletResponse response) throws IOException {
        User user = (User) request.getSession().getAttribute("loginUser");
        user.setGender(ParamT.getString(request,"gender",null));
        String bdate =ParamT.getString(request,"birthday","");
        if(bdate!=null){
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            try {
                user.setBirthday(df.parse(bdate));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        user.setAddress(ParamT.getString(request,"address",null));
        user.setSignature(ParamT.getString(request,"signature",null));
        if(userService.updateByPrimaryKey(user)){
            request.getSession().setAttribute("loginUser",user);
            JsonT.respJSON(response,true,"修改成功",null);
        }
    }

    @RequestMapping("/f/edituserphoto")//编辑用户头像
    public void usereditphoto(MultipartFile photofile, HttpServletRequest request, HttpServletResponse response) throws IOException {
        if(!photofile.isEmpty()) {
            String path = request.getServletContext().getRealPath("/upload/");
            String filename = StrT.genFileName(photofile.getOriginalFilename());
            File filepath = new File(path,filename);
            if (!filepath.exists()) {
                filepath.mkdirs();
            }
            photofile.transferTo(new File(path + File.separator + filename));
            User user = (User) request.getSession().getAttribute("loginUser");
            user.setPhoto("/upload/"+filename);
            if(userService.updateByPrimaryKeySelective(user)){
                request.getSession().setAttribute("loginUser",user);
                JsonT.respJSON(response,true,"修改成功",request.getContextPath()+user.getPhoto());
            }
        } else {
            JsonT.respJSON(response,false,"文件不能为空",null);
        }

    }

    @RequestMapping("/f/edituserpswd")//更改用户密码
    public void usereditpswd(String password,HttpServletRequest request,HttpServletResponse response) throws IOException {
        User user = (User) request.getSession().getAttribute("loginUser");
        User user1 = new User();
        user1.setUserid(user.getUserid());
        user1.setPassword(password);
        if(userService.updateByPrimaryKeySelective(user1)){
            JsonT.respJSON(response,true,"修改成功",null);
        }
    }

    @RequestMapping("/f/addAlbum")//新增用户相册
    public void addAlbum(MultipartFile photofile, Album album, HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = (User) request.getSession().getAttribute("loginUser");
        String filename ="";
        if(!photofile.isEmpty()) {
            String path = request.getServletContext().getRealPath("/upload/");
            filename = StrT.genFileName(photofile.getOriginalFilename());
            File filepath = new File(path,filename);
            if (!filepath.exists()) {
                filepath.mkdirs();
            }
            photofile.transferTo(new File(path + File.separator + filename));
            album.setAlbumCover("/upload/"+filename);
        }
        album.setAlbumUserid(user.getUserid());
        album.setCreatetime(new Date());
        if(albumService.insert(album)){
            JsonT.respJSON(response,true,"创建成功",null);
        }
    }

    /**
     * 修改用户相册
     * @param album
     * @param response
     * @throws IOException
     */
    @RequestMapping("/f/editAlbum")
    public void editAlbum(Album album, HttpServletResponse response) throws IOException {
        if(albumService.updateByPrimaryKeySelective(album)){
            JsonT.respJSON(response,true,"修改成功");
        }else{
            JsonT.respJSON(response,false,"修改失败");
        }
    }
    @RequestMapping("/f/getAlbum/{aid}")
    public void editAlbum(@PathVariable Integer aid, HttpServletResponse response) throws IOException {
        JsonT.respJSON(response,true,"获取成功",albumService.selectByPrimaryKey(aid));
    }
    @RequestMapping("/f/uploadAlbumCover")
    public void uploadAlbumCover(MultipartFile albumCover,HttpServletRequest request, HttpServletResponse response) {
        String filename ="";
        if(!albumCover.isEmpty()) {
            String path = request.getServletContext().getRealPath("/upload/");
            filename = StrT.genFileName(albumCover.getOriginalFilename());
            File filepath = new File(path,filename);
            if (!filepath.exists()) {
                filepath.mkdirs();
            }
            try {
                albumCover.transferTo(new File(path + File.separator + filename));
                JsonT.respJSON(response,true,"上传成功","/upload/"+filename);
            } catch (IOException e) {
                e.printStackTrace();
                JsonT.respJSON(response,false,"上传出错");
            }
        }
    }

    @RequestMapping("/f/getMyAlbums")//获取当前登录人的相册列表
    public void getMyAlbums(HttpServletRequest request,HttpServletResponse response) throws IOException {
        User user = (User) request.getSession().getAttribute("loginUser");
        AlbumExample example =new AlbumExample();
        example.createCriteria().andAlbumUseridEqualTo(user.getUserid());
        List<Album> list = albumService.selectByExample(example);
        JsonT.respJSON(response,true,"获取成功",list);
    }

    @RequestMapping("/f/delAlbum/{id}")//根据id删除相册
    public void delAlbum(@PathVariable Integer id, HttpServletResponse response) throws IOException {
        if(albumService.deleteByPrimaryKey(id)){
            JsonT.respJSON(response,true,"删除成功",null);
        }else{
            JsonT.respJSON(response,true,"删除失败",null);
        }
    }

    @RequestMapping("/f/showAlbum/{id}")//根据相册id展示相册内图片
    public void getMyAlbums(@PathVariable Integer id, HttpServletRequest request,HttpServletResponse response) throws IOException {
        UploadFileExample example =new UploadFileExample();
        UploadFileExample.Criteria criteria = example.createCriteria();
        criteria.andOwnertypeEqualTo("album");
        criteria.andOwneridEqualTo(id);
        List<UploadFile> list = uploadFileService.selectByExample(example);
        JsonT.respJSON(response,true,"获取成功",list);
    }

    @RequestMapping("/f/delUpFile/{id}")//根据id删除上传的文件
    public void delUpfile(@PathVariable Integer id, HttpServletResponse response) throws IOException {
        UploadFile file = uploadFileService.selectByPrimaryKey(id);
        if(uploadFileService.deleteByPrimaryKey(id)){
            JsonT.respJSON(response,true,"删除成功",file.getOwnerid());
        }else{
            JsonT.respJSON(response,true,"删除失败",null);
        }
    }

    @RequestMapping("/f/uploadAlbumphoto/{id}")//上传相册图片
    public void uploadphoto(@PathVariable Integer id, HttpServletRequest request, HttpServletResponse response) throws IOException {
        String filepath = request.getSession().getServletContext().getRealPath("/upload/");
        if(!new File(filepath).exists()){ new File(filepath).mkdirs(); }
        List<String> result = new ArrayList<String>();
        MultiValueMap<String, MultipartFile> fMap = null;
        if(request instanceof MultipartHttpServletRequest){
            fMap =((MultipartHttpServletRequest)request).getMultiFileMap();
        }
        if(fMap!=null){
            for(String key: fMap.keySet()){//key==input的name值
                List<MultipartFile> fileList = fMap.get(key);
                for(MultipartFile mFile:fileList){
                    String oldName = mFile.getOriginalFilename();
                    String filename =StrT.genFileName(oldName);
                    try {
                        mFile.transferTo(new File(filepath+ File.separator +filename));
                        UploadFile file = new UploadFile();
                        file.setCreatetime(new Date());
                        file.setOriginalname(oldName);
                        file.setOwnerid(id);
                        file.setOwnertype("album");
                        file.setPathname("/upload/"+filename);
                        if(uploadFileService.insert(file)){
                            result.add(request.getContextPath()+file.getPathname());
                        }else{
                            result.add(oldName+":上传失败");
                        }
                    } catch (IOException e) {
                        result.add(oldName+":上传失败");
                    }
                }
            }
        }
        JsonT.respJSON(response,true,"上传成功",result);
    }

    @RequestMapping("/f/getMyFriends")//获取当前登录人的相册列表
    public void getMyFriends(HttpServletRequest request,HttpServletResponse response) throws IOException {
        User user = (User) request.getSession().getAttribute("loginUser");
        List<User> list =userService.selectFriendsByUserId(user.getUserid());
        JsonT.respJSON(response,true,"获取成功",list);
    }

    @RequestMapping("/f/getCircleMembers/{id}")//获取当前登录人的相册列表
    public void getCircleMembers(@PathVariable Integer id,HttpServletRequest request,HttpServletResponse response) throws IOException {
        List<User> members = userService.selectMembersByCircleId(id);
        StringBuilder memberIds =new StringBuilder();
        for(User user:members){
            memberIds.append("|").append(user.getUserid()).append("|");
        }
        JsonT.respJSON(response,true,memberIds.toString(),members);
    }
}

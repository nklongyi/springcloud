package com.nklongyi.Controller;

import com.nklongyi.Dao.Article;
import com.nklongyi.Dao.Columns;
import com.nklongyi.Service.ArticleService;
import com.nklongyi.Service.ColumnsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by longyi on 2017/8/23.
 * 文章控制器
 */
@Controller
public class ArticleController {

     @Autowired
     ColumnsService columnsService;
     @Autowired
     ArticleService articleService;

    /**
     * 文章列表
     * @return
     */
    @RequestMapping("/admin/articles")
    public ModelAndView showUserIndex(){
        List<Article> articleList = articleService.findAll();
        return new ModelAndView("admin/Article/index","articleList",articleList);
    }

    @RequestMapping(value = "/admin/addArticles",method = RequestMethod.GET)
    public ModelAndView addArticle(@ModelAttribute Article article){
        List<Columns> columnsList = columnsService.findAll();
        ModelMap modelMap = new ModelMap();
        modelMap.put("columnsList",columnsList);
        return new ModelAndView("admin/Article/add",modelMap);
    }




    /***************************************************************栏目管理*************************************/
    /**
     * 进入栏目管理页面
     * @return
     */
    @RequestMapping(value = "/admin/columns",method = RequestMethod.GET)
    public ModelAndView showColumn(){
        List<Columns> columnsList = columnsService.findAll();
        return new ModelAndView("admin/Article/listColumns","columnsList",columnsList);
    }

    /**
     * 增加栏目
     * @return
     */
    @RequestMapping(value = "/admin/addColumns",method = RequestMethod.GET)
    public String addColumn(@ModelAttribute Columns columns){

        return "admin/Article/addColumns";
    }


    @RequestMapping(value = "/admin/saveColumns",method = RequestMethod.POST)
    public ModelAndView  saveColumn(Columns columns){
        columnsService.save(columns);
        return new ModelAndView("redirect:/admin/columns");
    }

    /**
     *修改栏目
     * @param modelMap
     * @param id
     * @return
     */
    @RequestMapping(value = "/admin/updateColumns/{id}")
    public ModelAndView updateColumn(ModelMap modelMap, @PathVariable Long id){
            Columns columns = columnsService.findById(id);
            modelMap.put("columns",columns);
            return new ModelAndView("admin/Article/editColumns",modelMap);
    }

    /**
     * 保存修改栏目信息
     * @param columns
     * @param request
     * @return
     */
    @RequestMapping(value = "/admin/updateColumns",method = RequestMethod.POST)
    public String updateColumn(Columns columns, HttpServletRequest request){
        Columns old = columnsService.findByName(columns.getName());
        old.setIntro(columns.getIntro());
        old.setName(columns.getName());
        columnsService.save(old);

        return "redirect:/admin/columns";//保存成功以后跳转到列表
    }

    /**
     * 删除栏目
     * @param id
     * @return
     */
    @RequestMapping(value = "/admin/deleteColumns/{id}",method = RequestMethod.GET)
    public String  deleteColumn(@PathVariable long id){
        columnsService.deleteById(id);
        return "redirect:/admin/columns";
    }
}

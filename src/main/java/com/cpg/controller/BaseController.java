package com.cpg.controller;

import com.cpg.dao.SearchDAOImpl;
import com.cpg.pojo.LoginBean;
import com.cpg.pojo.ProjectDetails;
import com.cpg.pojo.ProjectInfo;
import com.cpg.service.SearchDetails;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BaseController
{
  SearchDAOImpl searchDAO;
  
  @Inject
  public BaseController(SearchDAOImpl searchDAOImpl)
  {
    searchDAO = searchDAOImpl;
  }
  
  @RequestMapping({"/welcome"})
  protected ModelAndView home(HttpServletRequest request, HttpServletResponse response)
    throws Exception
  {
    ProjectDetails projDtls = ProjectDetails.getInstance();
    if (!projDtls.isSearchParam())
    {
      searchDAO.getSearchParameter();
    }
    return new ModelAndView("SearchScreen", "projDtls", projDtls);
  }
  
  @RequestMapping(value={"/search"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("projDtls") ProjectDetails projDtls)
    throws Exception
  {
    ProjectDetails tempProjDtls = ProjectDetails.getInstance();
    projDtls.setConnection(tempProjDtls.getConnection());
    projDtls.setProjectNameMap(tempProjDtls.getProjectNameMap());
    projDtls.setProjectSectorMap(tempProjDtls.getProjectSectorMap());
    projDtls.setModuleNameMap(tempProjDtls.getModuleNameMap());
    projDtls.setCustomizationTypeMap(tempProjDtls.getCustomizationTypeMap());
    
    SearchDetails searchDetails = new SearchDetails();
    List<ProjectInfo> searchResult = searchDetails.fetchDetails(projDtls);
    projDtls.setProjectInfo(searchResult);
    return new ModelAndView("SearchScreen", "projDtls", projDtls);
  }
  
  @RequestMapping(value={"/downloadFile"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public void doDownload(HttpServletRequest request, HttpServletResponse response, @RequestParam("filePath") String customozationId)
    throws IOException
  {
    ProjectDetails tempProjDtls = ProjectDetails.getInstance();
    Connection conn = tempProjDtls.getConnection();
    
    System.out.println("CustomizationId :" + customozationId);
    
    SearchDetails searchDetails = new SearchDetails();
    searchDetails.getFileFromDataBase(request, response, conn, customozationId);
  }
  
  @RequestMapping({"/upload"})
  public ModelAndView uploadView() 
  {
    ProjectDetails projDtls = ProjectDetails.getInstance();
    if (!projDtls.isSearchParam())
    {
      searchDAO.getSearchParameter();
    }
    return new ModelAndView("upload", "projDtls", projDtls);
  }
  
  @RequestMapping(value={"/upload"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public ModelAndView upload(HttpServletRequest request, HttpServletResponse response)
    throws Exception
  {
    ProjectDetails projDtls = ProjectDetails.getInstance();
    if (!projDtls.isSearchParam())
    {
      searchDAO.getSearchParameter();
    }
    return new ModelAndView("upload", "projDtls", projDtls);
  }
  
  @RequestMapping(value={"/login"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws Exception
  {
    ProjectDetails projDtls = ProjectDetails.getInstance();
    if (!projDtls.isSearchParam())
    {
      searchDAO.getSearchParameter();
    }
    return new ModelAndView("login", "projDtls", projDtls);
  }
  
  @RequestMapping(value={"/login"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public String submit(Model model, @ModelAttribute("loginBean") LoginBean loginBean)
  {
    if (loginBean != null) { if (((loginBean.getUserName() != null ? 1 : 0) & (loginBean.getPassword() != null ? 1 : 0)) != 0)
      {
        if ((loginBean.getUserName().equals("ns_repos")) && (loginBean.getPassword().equals("ns_repos")))
        {
          ProjectDetails projDtls = ProjectDetails.getInstance();
          model.addAttribute("projDtls", projDtls);
          return "upload";
        }      
        model.addAttribute("error", "Invalid Details");
        return "login";
      }
    }
    model.addAttribute("error", "Please enter Details");
    return "login";
  }
  
  @ExceptionHandler({Exception.class})
  public ModelAndView handleAllException(Exception ex)
  {
    ProjectDetails projDtls = ProjectDetails.getInstance();
    ModelAndView model = new ModelAndView("SearchScreen", "projDtls", projDtls);
    model.addObject("errMsg", "Unhandled Exception occured, try again.");
    return model;
  }
}
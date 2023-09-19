package controller;

import model.EGender;
import service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name = "StudentController", value = "/student")
public class StudentController extends HttpServlet {
    private StudentService studentService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int index = 0;
        String action = req.getParameter("action");
        if(action == null){
            action = "";
        }else {
            String strIndex = action.replaceAll("[^0-9]", "");
            index = Integer.parseInt(strIndex);
        }
        if(action.contains("create1")){
            viewCreate(req, resp);
        }else if (action.contains("edit")) {
            viewEdit(req, resp, index);
        }
        else if (action.contains("restore")) {
            viewRestore(req, resp);
        }else if (action.contains("delete")) {
            viewDelete(req, resp, index);
        }else showData(req,resp);
    }

    private void viewRestore(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("studentRestore", studentService.getAllRestore());
        req.getRequestDispatcher("restore.jsp").forward(req, resp);
    }

    private void viewDelete(HttpServletRequest req, HttpServletResponse resp, int index) throws ServletException, IOException {
        req.setAttribute("students", studentService.getAll());
        req.setAttribute("obj", studentService.getElementById(index));
        req.getRequestDispatcher("delete.jsp").forward(req,resp);
    }

    private void viewEdit(HttpServletRequest req, HttpServletResponse resp, int index) throws ServletException, IOException {
        req.setAttribute("studentIndex",studentService.getElementById(index));
        req.setAttribute("genders", EGender.values());
        req.setAttribute("index", index);
        req.getRequestDispatcher("edit.jsp").forward(req,resp);
    }


    private void viewCreate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("genders", EGender.values());
        req.getRequestDispatcher("create.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            int index = 0;
            String action = req.getParameter("action");
            if(action == null){
                action = "";
            }else {
                String strIndex = action.replaceAll("[^0-9]", "");
                index = Integer.parseInt(strIndex);
            }
            if(action.contains("create")){
                createNewStudent(req, resp);
            }else if (action.contains("edit")) {
                editStudent(req, resp, index);
            } else if (action.contains("delete")) {
                deleteStudent(req, resp, index);
            }
            else if (action.contains("restore")) {
                restoreStudent(req, resp, index);
            }else if (action.contains("no")) {
                showData(req,resp);
            } else showData(req,resp);
    }

    private void restoreStudent(HttpServletRequest req, HttpServletResponse resp, int index) throws IOException, ServletException {
        studentService.addStudent(studentService.getElementRestoreById(index));
        req.setAttribute("studentRestore", studentService.getAllRestore());
        req.getRequestDispatcher("restore.jsp").forward(req, resp);
    }

    private void editStudent(HttpServletRequest req, HttpServletResponse resp, int index) throws IOException {
        String name = req.getParameter("name");
        LocalDate dob = LocalDate.parse(req.getParameter("dob"));
        EGender gender = EGender.valueOf(req.getParameter("gender"));
        studentService.updateStudent(index, name, dob, gender);
        resp.sendRedirect("/student?message=Updated!");
    }
    private void deleteStudent(HttpServletRequest req, HttpServletResponse resp, int index) throws ServletException, IOException {
        studentService.deleteById(index);
        resp.sendRedirect("/student?message=Deleted!");
    }
    private void createNewStudent(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("name");
        LocalDate dob = LocalDate.parse(req.getParameter("dob"));
        EGender gender = EGender.valueOf(req.getParameter("gender"));
        studentService.addStudent(name, dob, gender);
        resp.sendRedirect("/student?message=Created!");
    }
    @Override
    public void init() throws ServletException {
        studentService =new StudentService();
    }
    protected void showData(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("students", studentService.getAll());
        req.getRequestDispatcher("student.jsp").forward(req, resp);
    }
}

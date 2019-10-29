package com.spring.gameloft.jpa;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Service
@Transactional
public class QueryServiceJson {

    private final String Agg1 = "SELECT AVG(e.salary) " +
            "FROM Employee e";
    private final String Agg2 = "SELECT d.name, AVG(e.salary) " +
            "FROM Department d JOIN d.employees e " +
            "GROUP BY d.name";
    private final String Agg3 = "SELECT d.name, AVG(e.salary) " +
            "FROM Department d JOIN d.employees e " +
            "WHERE e.directs IS EMPTY " +
            "GROUP BY d.name";
    private final String Agg4 = "SELECT d.name, AVG(e.salary) " +
            "FROM Department d JOIN d.employees e " +
            "WHERE e.directs IS EMPTY " +
            "GROUP BY d.name " +
            "HAVING AVG(e.salary) > 50000";
    private final String Agg5 = "SELECT d.name, e.salary " +
            "FROM Department d JOIN d.employees e " +
            "WHERE e.directs IS EMPTY";
    private final String Agg6 = "SELECT e, COUNT(p), COUNT(DISTINCT p.type) " +
            "FROM Employee e JOIN e.phones p " +
            "GROUP BY e";
    private final String DELETE = "DELETE FROM Employee e " +
            "WHERE e.department IS NULL";
    private final String FROM1 = "SELECT p  " +
            "FROM Employee e JOIN e.phones p";
    private final String FROM10 = "SELECT DISTINCT p  " +
            "FROM Department d JOIN d.employees e JOIN e.projects p";
    private final String FROM11 = "SELECT e, d  " +
            "FROM Employee e LEFT JOIN e.department d";
    private final String FROM12 = "SELECT e  " +
            "FROM Employee e JOIN FETCH e.address";
    private final String FROM13 = "SELECT e, a  " +
            "FROM Employee e JOIN e.address a";
    private final String FROM14 = "SELECT d  " +
            "FROM Department d LEFT JOIN FETCH d.employees";
    private final String FROM15 = "SELECT d, e  " +
            "FROM Department d LEFT JOIN d.employees e";
    private final String FROM2 = "SELECT DISTINCT p  " +
            "FROM Employee e, IN(e.phones) p";
    private final String FROM3 = "SELECT p.number  " +
            "FROM Employee e JOIN e.phones p";
    private final String FROM4 = "SELECT d  " +
            "FROM Employee e JOIN e.department d";
    private final String FROM5 = "SELECT e.department  " +
            "FROM Employee e";
    private final String FROM6 = "SELECT DISTINCT e.department  " +
            "FROM Project p JOIN p.employees e " +
            "WHERE p.name = 'Release1' AND e.address.state = 'CA'";
    private final String FROM7 = "SELECT DISTINCT d  " +
            "FROM Project p JOIN p.employees e JOIN e.department d JOIN e.address a WHERE p.name = 'Release1' AND a.state = 'CA'";
    private final String FROM8 = "SELECT DISTINCT d  " +
            "FROM Department d, Employee e " +
            "WHERE d = e.department";
    private final String FROM9 = "SELECT d, m  " +
            "FROM Department d, Employee m " +
            "WHERE d = m.department AND m.directs IS NOT EMPTY";
    private final String GROUPBY1 = "SELECT d.name, COUNT(e) " +
            "FROM Department d JOIN d.employees e " +
            "GROUP BY d.name";
    private final String GROUPBY2 = "SELECT d.name, COUNT(e), AVG(e.salary) " +
            "FROM Department d JOIN d.employees e " +
            "GROUP BY d.name";
    private final String GROUPBY3 = "SELECT d.name, e.salary, COUNT(p) " +
            "FROM Department d JOIN d.employees e JOIN e.projects p " +
            "GROUP BY d.name, e.salary";
    private final String HAVING = "SELECT e, COUNT(p) " +
            "FROM Employee e JOIN e.projects p " +
            "GROUP BY e " +
            "HAVING COUNT(p) >= 2";
    private final String ORDERBY1 = "SELECT e " +
            "FROM Employee e " +
            "ORDER BY e.name DESC";
    private final String ORDERBY2 = "SELECT e " +
            "FROM Employee e JOIN e.department d " +
            "ORDER BY d.name, e.name DESC";
    private final String ORDERBY3 = "SELECT e.name " +
            "FROM Employee e " +
            "ORDER BY e.salary DESC";
    private final String SELECT1 = "SELECT e " +
            "FROM Employee e";
    private final String SELECT10 = "SELECT p  " +
            "FROM Project p " +
            "WHERE p.employees IS NOT EMPTY";
    private final String SELECT2 = "SELECT d  " +
            "FROM Department d";
    private final String SELECT3 = "SELECT OBJECT(d)  " +
            "FROM Department d";
    private final String SELECT4 = "SELECT e.name FROM Employee e";
    private final String SELECT5 = "SELECT e.department  " +
            "FROM Employee e";
    private final String SELECT6 = "SELECT DISTINCT e.department  " +
            "FROM Employee e";
    private final String SELECT7 = "SELECT d.employees  " +
            "FROM Department d";
    private final String SELECT8 = "SELECT e.name, e.salary  " +
            "FROM Employee e";
    private final String SELECT9 = "SELECT NEW spring.boot.jpa.jpql.EmployeeDetails(e.name, e.salary, e.department.name)  " +
            "FROM Employee e";
    private final String TITLE = "Query result";
    private final String UPDATE2 = "UPDATE Employee e " +
            "SET e.salary = e.salary + 5000 " +
            "WHERE EXISTS (SELECT p " +
            "FROM e.projects p " +
            "WHERE p.name = 'Release1')";
    private final String UPDATE1 = "UPDATE Employee e " +
            "SET e.salary = 60000 " +
            "WHERE e.salary = 55000";
    private final String GROUPBY4 = "SELECT COUNT(e), AVG(e.salary) " +
            "FROM Employee e";
    private final String WHERE1 = "SELECT e  " +
            "FROM Employee e " +
            "WHERE e.salary BETWEEN 40000 AND 45000";
    private final String WHERE10 = "SELECT p " +
            "FROM Phone p " +
            "WHERE p.type NOT IN ('Office', 'Home')";
    private final String WHERE11 = "SELECT e " +
            "FROM Employee e " +
            "WHERE e.directs IS NOT EMPTY";
    private final String WHERE12 = "SELECT m " +
            "FROM Employee m " +
            "WHERE (SELECT COUNT(e) " +
            "FROM Employee e " +
            "WHERE e.manager = m) > 0";
    private final String WHERE13 = "SELECT e " +
            "FROM Employee e " +
            "WHERE e MEMBER OF e.directs";
    private final String WHERE14 = "SELECT e " +
            "FROM Employee e " +
            "WHERE NOT EXISTS (SELECT p " +
            "FROM e.phones p " +
            "WHERE p.type = 'Cell')";
    private final String WHERE15 = "SELECT e " +
            "FROM Employee e " +
            "WHERE e.directs IS NOT EMPTY AND " +
            "e.salary < ALL (SELECT d.salary " +
            "FROM e.directs d)";
    private final String WHERE16 = "SELECT e " +
            "FROM Employee e " +
            "WHERE e.department = ANY (SELECT DISTINCT d FROM Department d JOIN d.employees de JOIN de.projects p " +
            "WHERE p.name LIKE 'QA%')";
    private final String WHERE17 = "SELECT d " +
            "FROM Department d " +
            "WHERE SIZE(d.employees) = 2";
    private final String WHERE18 = "SELECT d " +
            "FROM Department d " +
            "WHERE (SELECT COUNT(e) " +
            "FROM d.employees e) = 2";
    private final String WHERE2 = "SELECT e  " +
            "FROM Employee e " +
            "WHERE e.salary >= 40000 AND e.salary <= 45000";
    private final String WHERE3 = "SELECT d  " +
            "FROM Department d " +
            "WHERE d.name LIKE '__Eng%'";
    private final String WHERE4 = "SELECT d  " +
            "FROM Department d " +
            "WHERE d.name LIKE 'QA_";
    private final String WHERE5 = "SELECT e  " +
            "FROM Employee e " +
            "WHERE e.salary = (SELECT MAX(e2.salary) FROM Employee e2)";
    private final String WHERE6 = "SELECT e  " +
            "FROM Employee e " +
            "WHERE EXISTS (SELECT p FROM Phone p WHERE p.employee = e AND p.type = 'Cell')";
    private final String WHERE7 = "SELECT e  " +
            "FROM Employee e " +
            "WHERE EXISTS (SELECT p FROM e.phones p WHERE p.type = 'Cell')";
    private final String WHERE8 = "SELECT e  " +
            "FROM Employee e " +
            "WHERE e.address.state IN ('NY', 'CA')";
    private final String WHERE9 = "SELECT e " +
            "FROM Employee e " +
            "WHERE e.department IN (SELECT DISTINCT d " +
            "FROM Department d JOIN d.employees de JOIN de.projects p " +
            "WHERE p.name LIKE 'QA%')";
    private String UPDATE3 = "UPDATE Phone p " +
            "SET p.number = CONCAT('288', SUBSTRING(p.number, LOCATE('-',p.number), 4)), " +
            "p.type = 'Business' " +
            "WHERE p.employee.address.city = 'New York' AND p.type = 'Office'";

    @PersistenceContext
    private EntityManager em;

    public List runQuery(String query, String queryString, PrintWriter out) throws IOException {
        printHtmlHeader(out);
        switch (query) {
            case "dynamic":
                return executeAndPrintQuery(queryString, out);
            //break;
            case "SELECT1":
                return executeAndPrintQuery(SELECT1, out);
            //break;
            case "SELECT2":
                return executeAndPrintQuery(SELECT2, out);
            //break;
            case "SELECT3":
                return executeAndPrintQuery(SELECT3, out);
            //break;
            case "SELECT4":
                return executeAndPrintQuery(SELECT4, out);
            //break;
            case "SELECT5":
                return executeAndPrintQuery(SELECT5, out);
            //break;
            case "SELECT6":
                return executeAndPrintQuery(SELECT6, out);
            //break;
            case "SELECT7":
                return executeAndPrintQuery(SELECT7, out);
            //break;
            case "SELECT8":
                return executeAndPrintQuery(SELECT8, out);
            //break;
            case "SELECT9":
                return executeAndPrintQuery(SELECT9, out);
            //break;
            case "SELECT10":
                return executeAndPrintQuery(SELECT10, out);
            //break;
            case "FROM1":
                return executeAndPrintQuery(FROM1, out);
            //break;
            case "FROM2":
                return executeAndPrintQuery(FROM2, out);
            //break;
            case "FROM3":
                return executeAndPrintQuery(FROM3, out);
            //break;
            case "FROM4":
                return executeAndPrintQuery(FROM4, out);
            //break;
            case "FROM5":
                return executeAndPrintQuery(FROM5, out);
            //break;
            case "FROM6":
                return executeAndPrintQuery(FROM6, out);
            //break;
            case "FROM7":
                return executeAndPrintQuery(FROM7, out);
            //break;
            case "FROM8":
                return executeAndPrintQuery(FROM8, out);
            //break;
            case "FROM9":
                return executeAndPrintQuery(FROM9, out);
            //break;
            case "FROM10":
                return executeAndPrintQuery(FROM10, out);
            //break;
            case "FROM11":
                return executeAndPrintQuery(FROM11, out);
            //break;
            case "FROM12":
                return executeAndPrintQuery(FROM12, out);
            //break;
            case "FROM13":
                return executeAndPrintQuery(FROM13, out);
            //break;
            case "FROM14":
                return executeAndPrintQuery(FROM14, out);
            //break;
            case "FROM15":
                return executeAndPrintQuery(FROM15, out);
            //break;
            case "WHERE1":
                return executeAndPrintQuery(WHERE1, out);
            //break;
            case "WHERE2":
                return executeAndPrintQuery(WHERE2, out);
            //break;
            case "WHERE3":
                return executeAndPrintQuery(WHERE3, out);
            //break;
            case "WHERE4":
                return executeAndPrintQuery(WHERE4, out);
            //break;
            case "WHERE5":
                return executeAndPrintQuery(WHERE5, out);
            //break;
            case "WHERE6":
                return executeAndPrintQuery(WHERE6, out);
            //break;
            case "WHERE7":
                return executeAndPrintQuery(WHERE7, out);
            //break;
            case "WHERE8":
                return executeAndPrintQuery(WHERE8, out);
            //break;
            case "WHERE9":
                return executeAndPrintQuery(WHERE9, out);
            //break;
            case "WHERE10":
                return executeAndPrintQuery(WHERE10, out);
            //break;
            case "WHERE11":
                return executeAndPrintQuery(WHERE11, out);
            //break;
            case "WHERE12":
                return executeAndPrintQuery(WHERE12, out);
            //break;
            case "WHERE13":
                return executeAndPrintQuery(WHERE13, out);
            //break;
            case "WHERE14":
                return executeAndPrintQuery(WHERE14, out);
            //break;
            case "WHERE15":
                return executeAndPrintQuery(WHERE15, out);
            //break;
            case "WHERE16":
                return executeAndPrintQuery(WHERE16, out);
            //break;
            case "WHERE17":
                return executeAndPrintQuery(WHERE17, out);
            //break;
            case "WHERE18":
                return executeAndPrintQuery(WHERE18, out);
            //break;
            case "ORDERBY1":
                return executeAndPrintQuery(ORDERBY1, out);
            //break;
            case "ORDERBY2":
                return executeAndPrintQuery(ORDERBY2, out);
            //break;
            case "ORDERBY3":
                return executeAndPrintQuery(ORDERBY3, out);
            //break;
            case "Agg1":
                return executeAndPrintQuery(Agg1, out);
            //break;
            case "Agg2":
                return executeAndPrintQuery(Agg2, out);
            //break;
            case "Agg3":
                return executeAndPrintQuery(Agg3, out);
            //break;
            case "Agg4":
                return executeAndPrintQuery(Agg4, out);
            //break;
            case "Agg5":
                return executeAndPrintQuery(Agg5, out);
            //break;
            case "Agg6":
                return executeAndPrintQuery(Agg6, out);
            //break;
            case "GROUPBY1":
                return executeAndPrintQuery(GROUPBY1, out);
            //break;
            case "GROUPBY2":
                return executeAndPrintQuery(GROUPBY2, out);
            //break;
            case "GROUPBY3":
                return executeAndPrintQuery(GROUPBY3, out);
            //break;
            case "GROUPBY4":
                return executeAndPrintQuery(GROUPBY4, out);
            //break;
            case "HAVING":
                return executeAndPrintQuery(HAVING, out);
            //break;
            case "UPDATE1":
                return executeBulkQuery(UPDATE1, out);
            //break;
            case "UPDATE2":
                return executeBulkQuery(UPDATE2, out);
            //break;
            case "UPDATE3":
                return executeBulkQuery(UPDATE3, out);
            //break;
            case "DELETE":
                return executeBulkQuery(DELETE, out);
            //break;
        }
        printHtmlFooter(out);
        return null;
    }


    public List executeAndPrintQuery(String queryString, PrintWriter out) {
        Query query = em.createQuery(queryString);
        printQueryResult(queryString, query.getResultList(), out);
        return query.getResultList();
    }

    public List executeBulkQuery(String queryString, PrintWriter out) {
        em.createQuery(queryString).executeUpdate();
        out.println("<b>JPQL: </b>" + queryString + " </br>Done.");
        return Arrays.asList("Updating query executed successfully!");
    }

    private void printQueryResult(String queryString, List result, PrintWriter out) {
        out.println("<table><tbody>");
        out.println("<tr><td><b>JPQL: </b>" + queryString + "</td></tr>");
        out.println("<tr><td><b>Result:</b></td></tr>");
        if (result.isEmpty()) {
            out.println("<tr><td>No results Found</td></tr>");
        } else {
            for (Object o : result) {
                out.println("<tr><td>" + resultAsString(o) + "</td></tr>");
            }
        }
        out.println("</tbody></table>");
    }


    private String resultAsString(Object o) {
        if (o instanceof Object[]) {
            return Arrays.asList((Object[]) o).toString();
        } else {
            return String.valueOf(o);
        }
    }


    private void printHtmlHeader(PrintWriter out) throws IOException {
        out.println("<body>");
        out.println("<html>");
        out.println("<head><title>" + TITLE + "</title></head>");
    }


    private void printHtmlFooter(PrintWriter out) throws IOException {
        out.println("<hr/>");
        out.println("<a href=\"index.html\">Back</a>");
        out.println("</html>");
        out.println("</body>");
        out.close();
    }
}

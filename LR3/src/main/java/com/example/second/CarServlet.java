@WebServlet("/car")
public class carController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String line = null;
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        String prefix="";
        File file = new File(getServletContext().getRealPath("/")+"car.json");
        idCar.id=1;
        try(BufferedReader br = new BufferedReader(new InputStreamReader(new
                FileInputStream(file), StandardCharsets.UTF_8))){
            while((line=br.readLine())!=null) {
                sb.append(prefix);
                prefix=",";
                sb.append(line);
                idCar.id++;
            }
        }
        sb.append("]");
        PrintWriter pw = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        pw.println(sb.toString());
        pw.flush();

        System.out.println("прочитано"+sb.toString()+getServletContext().getRealPath("/"));
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        StringBuffer sb = new StringBuffer();
        String line = null;
        BufferedReader reader = request.getReader();
        final char dm = (char) 34;
        while((line=reader.readLine())!=null) {
            sb.append(line);
            sb.insert(1,dm+"id"+dm+":"+dm+idCar.id+dm+",");
        }
        File file = new File(getServletContext().getRealPath("/")+"car.json");
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(file,true))) {
            if(idCar.id==1)
                bw.append(sb.toString());
            else
                bw.append("\n"+sb.toString());
        }
        idCar.id++;
        PrintWriter pw = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        pw.println(sb.toString());
        pw.flush();
        System.out.println("записано:"+sb.toString());
    }
}
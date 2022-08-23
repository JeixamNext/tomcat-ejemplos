package curso;
import org.apache.catalina.valves.ValveBase;
	import org.apache.catalina.connector.Request;
	import org.apache.catalina.connector.Response;
	import org.apache.catalina.Valve;

	import javax.servlet.ServletException;
	import java.io.IOException;


	public class EjemploValve extends ValveBase{
	    @Override
	    public void invoke(Request request, Response response) throws IOException, ServletException {
	        String remoteAddress = request.getRemoteHost();
	        String requestUri = request.getRequestURI();

	        System.out.println("URI " + requestUri + " accedida desde la direccion:"+remoteAddress);

	        Valve nextValve = getNext();
	        if(nextValve!=null){
	            nextValve.invoke(request, response);
	        }

	    }
	}



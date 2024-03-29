package gt.edu.url;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //CSP
        //Variables
        List<String> variables = List.of("Western Australia", "Northern Territory",
                "Queensland", "South Australia", "New South Wales", "Victoria", "Tasmania");
        //Dominios
        Map<String, List<String>> domains = new HashMap<>();
        for (var variable:variables){
            domains.put(variable, List.of("rojo", "verde", "azul"));
        }
        //Restricciones
        CSP<String, String> problema = new CSP<>(variables, domains);
        problema.addConstraint(new AustraliaColoringConstraint("Western Australia", "Northern Territory"));
        problema.addConstraint(new AustraliaColoringConstraint("Western Australia", "South Australia"));
        problema.addConstraint(new AustraliaColoringConstraint("Northern Territory", "South Australia"));
        problema.addConstraint(new AustraliaColoringConstraint("Northern Territory", "Queensland"));
        problema.addConstraint(new AustraliaColoringConstraint("Queensland", "South Australia"));
        problema.addConstraint(new AustraliaColoringConstraint("Queensland", "New South Wales"));
        problema.addConstraint(new AustraliaColoringConstraint("South Australia", "New South Wales"));
        problema.addConstraint(new AustraliaColoringConstraint("South Australia", "Victoria"));
        problema.addConstraint(new AustraliaColoringConstraint("Victoria", "New South Wales"));
        problema.addConstraint(new AustraliaColoringConstraint("Tasmania", "Victoria"));
        var solution = problema.backtrack();
        System.out.println(solution);
    }
}

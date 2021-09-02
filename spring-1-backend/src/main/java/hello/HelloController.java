package hello;

import org.springframework.web.bind.annotation.*;
import hello.StudentAdmission.Status;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
@CrossOrigin(origins = "http://localhost:3000")
        public class HelloController {
        @RequestMapping("/")
        public String index() {
            return "Greetings from Spring Boot!";
        }


    @RequestMapping(value="/admission-status", method= RequestMethod.GET)
    public StudentAdmission getAdmissionStatus(
            @RequestParam(value="name", defaultValue="") String name) {
        Status status = name.contains("Baylor") ? Status.ACCEPTED :
                Status.DENIED;
        StudentAdmission sa = new StudentAdmission(name, status);
        return sa;
    }
}




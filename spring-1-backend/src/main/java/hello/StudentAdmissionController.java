package hello;

import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class StudentAdmissionController {

    @RequestMapping(value = "/api/admission-statuses", method = RequestMethod.GET)
    public StudentAdmission.Status[] getStatuses() {
        return StudentAdmission.Status.values();
    }

    @RequestMapping(value = "/api/update-admission", method = RequestMethod.POST)
    public StudentAdmissionForm updateAdmission(@RequestBody StudentAdmissionForm
                                                        studentAdmissionForm) {
// Some Business Logic
        if (studentAdmissionForm.getName().contains("Baylor")) {
            studentAdmissionForm.setStatus(StudentAdmission.Status.ACCEPTED.toString());
        }
        return studentAdmissionForm;
    }
}

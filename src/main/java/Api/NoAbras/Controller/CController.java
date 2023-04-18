package Api.NoAbras.Controller;

import Api.NoAbras.Model.CModel;
import Api.NoAbras.Security.service.CService;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/model")
public class CController {
    @Autowired
    CService cService;

    @GetMapping("")
    public List<CModel> readConsultation(){
        return cService.readConsultation();
    }

    @PostMapping("")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public void createConsultation(@RequestBody CModel model){
        cService.createConsultation(model);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Optional<CModel> readConsultationId(@PathVariable("id") Long id){
        return cService.readConsultationId(id);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void updateConsultation(@RequestBody CModel model,@PathVariable("id")Long id){
        cService.updateConsultation(model,id);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteConsultation(@PathVariable("id")Long id){
        cService.deleteConsultation(id);
    }

}



package Api.NoAbras.Controller;

import Api.NoAbras.Model.CModel;
import Api.NoAbras.Service.CService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/model")
@CrossOrigin("*")

public class CController {
    @Autowired
    CService cService;

    @GetMapping("")
    private List<CModel> readConsultation(){
        return cService.readConsultation();

    }
    @GetMapping("/{id}")
    private Optional<CModel> readConsultationId(@PathVariable("id") Long id){
        return cService.readConsultationId(id);

    }

    @PostMapping("")
    private void createConsultation(@RequestBody CModel model){
        cService.createConsultation(model);

    }
    @PutMapping("/{id}")
    private void updateConsultation(@RequestBody CModel model,@PathVariable("id")Long id){
        cService.updateConsultation(model,id);

    }


    @DeleteMapping("/{id}")
    private void deleteConsultation(@PathVariable("id")Long id){
        cService.deleteConsultation(id);


    }

}



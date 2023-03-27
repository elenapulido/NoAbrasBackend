package Api.NoAbras.Service;

import Api.NoAbras.Model.CModel;
import Api.NoAbras.Repository.IRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class CService {
    @Autowired

    private IRepository iRepository;

    public void createConsultation(CModel model){
        iRepository.save(model);

    }

    public List<CModel>readConsultation(){
        List<CModel> models = new ArrayList<CModel>(iRepository.findAll());
        return models;

    }
    public Optional<CModel> readConsultationId(Long id){
        Optional<CModel> model = iRepository.findById(id);
        return model;
    }

    public void updateConsultation(CModel model, Long id){
        model.setId(id);
        iRepository.save(model);

    }

    public void deleteConsultation(Long id){
        iRepository.deleteById(id);


    }


    public void setiRepository(IRepository iRepository) {
        this.iRepository = iRepository;
    }
}


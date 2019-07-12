package org.koritsas.vinnslu.main.ws.services.workflow;

import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.koritsas.vinnslu.main.models.topo.*;
import org.koritsas.vinnslu.main.models.topo.applications.LeasingApplication;
import org.koritsas.vinnslu.main.ws.services.applications.LeasingApplicationService;
import org.koritsas.vinnslu.main.ws.services.crud.topo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
public class LeasingSubprocessService {

    private RuntimeService runtimeService;

    private TaskService taskService;

    private EnvironmentalImpactStudyService environmentalImpactStudyService;

    private TechnicalStudyService technicalStudyService;

    private GuaranteeService guaranteeService;

    private LeasingResolutionService leasingResolutionService;

    private MiningLicenseService miningLicenseService;

    private LeasingApplicationService leasingApplicationService;

    private EstablishmentProtocolService establishmentProtocolService;

    @Autowired
    public LeasingSubprocessService(RuntimeService runtimeService,TaskService taskService,EnvironmentalImpactStudyService environmentalImpactStudyService,TechnicalStudyService technicalStudyService,GuaranteeService guaranteeService,LeasingResolutionService leasingResolutionService,MiningLicenseService miningLicenseService, LeasingApplicationService leasingApplicationService,EstablishmentProtocolService establishmentProtocolService){
        this.runtimeService=runtimeService;
        this.taskService=taskService;
        this.environmentalImpactStudyService=environmentalImpactStudyService;
        this.technicalStudyService=technicalStudyService;
        this.guaranteeService=guaranteeService;
        this.leasingResolutionService=leasingResolutionService;
        this.miningLicenseService=miningLicenseService;
        this.leasingApplicationService=leasingApplicationService;
        this.establishmentProtocolService=establishmentProtocolService;
    }

    @Transactional
    public void createEnvironmentalImpactStudy(String taskId,EnvironmentalImpactStudy environmentalImpactStudy){

        Map<String,Object> variables = new HashMap<>();

        variables.put("environmentalImpactStudy",environmentalImpactStudyService.create(environmentalImpactStudy));

        taskService.complete(taskId,variables);

    }

    @Transactional
    public  void updateEnvironmentalImpactStudy(String taskId,EnvironmentalImpactStudy environmentalImpactStudy){

        Map<String,Object> variables = new HashMap<>();

        variables.put("environmentalImpactStudy",environmentalImpactStudyService.update(environmentalImpactStudy.getId(),environmentalImpactStudy));

        taskService.complete(taskId,variables);
    }


    @Transactional
    public void createTechnicalStudy(String taskId, TechnicalStudy technicalStudy){

        Map<String,Object> variables = new HashMap<>();

        variables.put("technicalStudy",technicalStudyService.create(technicalStudy));

        taskService.complete(taskId,variables);

    }

    @Transactional
    public void updateTechnicalStudy(String taskId,TechnicalStudy technicalStudy){

        Map<String,Object> variables = new HashMap<>();

        variables.put("technicalStudy",technicalStudyService.update(technicalStudy.getId(),technicalStudy));

        taskService.complete(taskId,variables);

    }

    @Transactional
    public void createEnvironmentalGuaranteeLetter(String taskId,Guarantee guarantee){

        Map<String,Object> variables = new HashMap<>();

        variables.put("environmentalGuaranteeLetter",guaranteeService.create(guarantee));

        taskService.complete(taskId,variables);


    }

    @Transactional
    public void createLeasingGuaranteeLetter(String taskId,Guarantee guarantee){

        Map<String,Object> variables = new HashMap<>();

        variables.put("leasingGuaranteeLetter",guaranteeService.create(guarantee));

        taskService.complete(taskId,variables);

    }

    @Transactional
    public void createLeasingResolution(String taskId, LeasingResolution leasingResolution){

        Map<String,Object> variables = new HashMap<>();

        variables.put("leasingResolution",leasingResolutionService.create(leasingResolution));

        taskService.complete(taskId,variables);

    }

    @Transactional
    public  void createMiningLicense(String taskId,MiningLicense miningLicense){

        Map<String,Object> variables = new HashMap<>();

        variables.put("miningLicense",miningLicenseService.create(miningLicense));

        taskService.complete(taskId,variables);
    }

    @Transactional
    public void createLeasingApplication(String taskId, LeasingApplication leasingApplication){

        Map<String,Object> variables = new HashMap<>();

        variables.put("leasingApplication",leasingApplicationService.create(leasingApplication));

        taskService.complete(taskId,variables);

    }

    @Transactional
    public void createEstablishmentProtocol(String taskId, EstablishmentProtocol establishmentProtocol){

        Map<String,Object> variables = new HashMap<>();

        variables.put("establishmentProtocol",establishmentProtocolService.create(establishmentProtocol));

    }






}

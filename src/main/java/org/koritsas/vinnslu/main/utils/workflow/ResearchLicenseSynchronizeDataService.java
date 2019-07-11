package org.koritsas.vinnslu.main.utils.workflow;

import lombok.RequiredArgsConstructor;
import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;
import org.koritsas.vinnslu.main.models.topo.ResearchLicense;
import org.koritsas.vinnslu.main.models.topo.StandardEnvironmentalCommitments;
import org.koritsas.vinnslu.main.models.topo.StandardTechnicalCommitments;
import org.koritsas.vinnslu.main.models.topo.applications.ResearchApplication;
import org.koritsas.vinnslu.main.models.topo.applications.StandardEnvironmentalCommitmentsApplication;
import org.koritsas.vinnslu.main.models.topo.applications.StandardTechnicalCommitmentsApplication;
import org.koritsas.vinnslu.main.ws.repos.applications.ResearchApplicationRepository;
import org.koritsas.vinnslu.main.ws.repos.topo.ResearchLicenseRepository;
import org.koritsas.vinnslu.main.ws.services.applications.ResearchApplicationService;
import org.koritsas.vinnslu.main.ws.services.applications.StandardEnvironmentalCommitmentsApplicationService;
import org.koritsas.vinnslu.main.ws.services.applications.StandardTechnicalCommitmentsApplicationService;
import org.koritsas.vinnslu.main.ws.services.crud.topo.ResearchLicenseService;
import org.koritsas.vinnslu.main.ws.services.crud.topo.StandardEnvironmentalCommitmentsService;
import org.koritsas.vinnslu.main.ws.services.crud.topo.StandardTechnicalCommitmentsService;

@RequiredArgsConstructor
public class ResearchLicenseSynchronizeDataService implements JavaDelegate {

    private ResearchLicenseService researchLicenseService;

    private ResearchApplicationService researchApplicationService;

    private StandardEnvironmentalCommitmentsService standardEnvironmentalCommitmentsService;

    private StandardTechnicalCommitmentsService standardTechnicalCommitmentsService;

    private StandardEnvironmentalCommitmentsApplicationService secApplicationService;

    private StandardTechnicalCommitmentsApplicationService stcApplicationService;




    @Override
    public void execute(DelegateExecution execution) {

        System.out.println(" Java task. Will be used later");

/*

        ResearchLicense researchLicense = (ResearchLicense) execution.getVariable("researchLicense");

        ResearchApplication researchApplication = (ResearchApplication) execution.getVariable("researchApplication");

        StandardEnvironmentalCommitments sec = (StandardEnvironmentalCommitments) execution.getVariable("standardEnvironmentalCommitments");

        StandardTechnicalCommitments stc = (StandardTechnicalCommitments) execution.getVariable("standardTechnicalCommitments");

        StandardTechnicalCommitmentsApplication stcApplication = (StandardTechnicalCommitmentsApplication) execution.getVariable("standardTechnicalCommitmentsApplication");

        StandardEnvironmentalCommitmentsApplication secApplication = (StandardEnvironmentalCommitmentsApplication) execution.getVariable("standardEnvironmentalCommitmentsApplication");


        stc.setStandardTechnicalCommitmentsApplication(stcApplication);

        sec.setStandardEnvironmentalCommitmentsApplication(secApplication);

        researchLicense.getTopo().setTopoOwner(researchApplication.getSender());

        researchLicense.setStandardEnvironmentalCommitments(sec);

        researchLicense.setStandardTechnicalCommitments(stc);


        secApplicationService.update(secApplication.getId(),secApplication);

        stcApplicationService.update(stcApplication.getId(),stcApplication);

        standardEnvironmentalCommitmentsService.update(sec.getId(),sec);

        standardTechnicalCommitmentsService.update(stc.getId(),stc);

        researchApplicationService.update(researchApplication.getId(),researchApplication);

        researchLicenseService.update(researchLicense.getId(),researchLicense);

*/

    }
}

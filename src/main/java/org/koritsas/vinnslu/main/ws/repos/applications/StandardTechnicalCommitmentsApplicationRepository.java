package org.koritsas.vinnslu.main.ws.repos.applications;

import org.koritsas.vinnslu.main.models.topo.StandardTechnicalCommitments;
import org.koritsas.vinnslu.main.models.topo.applications.StandardTechnicalCommitmentsApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StandardTechnicalCommitmentsApplicationRepository extends JpaRepository<StandardTechnicalCommitmentsApplication, Long> {
}

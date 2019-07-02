package org.koritsas.vinnslu.main.ws.repos.applications;

import org.koritsas.vinnslu.main.models.topo.StandardEnvironmentalCommitments;
import org.koritsas.vinnslu.main.models.topo.applications.StandardEnvironmentalCommitmentsApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StandardEnvironmentalCommitmentsApplicationRepository extends JpaRepository<StandardEnvironmentalCommitmentsApplication, Long> {
}

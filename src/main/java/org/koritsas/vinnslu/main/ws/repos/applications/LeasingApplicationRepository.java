package org.koritsas.vinnslu.main.ws.repos.applications;

import org.koritsas.vinnslu.main.models.topo.applications.LeasingApplication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeasingApplicationRepository extends JpaRepository<LeasingApplication,Long> {
}

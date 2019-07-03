package org.koritsas.vinnslu.main.ws.repos.topo;

import org.koritsas.vinnslu.main.models.topo.StandardEnvironmentalCommitments;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StandardEnvironmentalCommitmentsRepository extends JpaRepository<StandardEnvironmentalCommitments, Long> {


    StandardEnvironmentalCommitments findByProtocol(String protocol);

    StandardEnvironmentalCommitments findByAda(String ada);


}

package org.koritsas.vinnslu.main.ws.repos.common;

import org.koritsas.vinnslu.main.models.common.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority,Long> {

    Authority findByName(final String name);
    Authority findByAfm(final Long afm);
}

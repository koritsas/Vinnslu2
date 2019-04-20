package org.koritsas.vinnslu.main.ws.repos.common;

import org.koritsas.vinnslu.main.models.common.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company,Long> {

    Company findByName(final String name);
    Company findByAfm(final Long afm);
}

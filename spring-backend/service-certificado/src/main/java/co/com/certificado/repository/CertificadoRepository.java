package co.com.certificado.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.common.certificado.model.Certificado;

public interface CertificadoRepository extends JpaRepository<Certificado, Long>{

}

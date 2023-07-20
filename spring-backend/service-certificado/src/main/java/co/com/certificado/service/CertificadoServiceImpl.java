package co.com.certificado.service;

import org.springframework.stereotype.Service;

import co.com.certificado.repository.CertificadoRepository;
import co.com.common.certificado.model.Certificado;
import co.com.common.generic.service.CommonServiceImpl;

@Service
public class CertificadoServiceImpl extends CommonServiceImpl<Certificado, CertificadoRepository> implements CertificadoService{

}

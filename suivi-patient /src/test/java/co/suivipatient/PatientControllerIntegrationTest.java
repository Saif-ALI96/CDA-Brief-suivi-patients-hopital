package co.suivipatient;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.sql.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import co.suivipatient.business.dto.PatientDTO;
import co.suivipatient.business.service.patient.PatientServiceImpl;
import co.suivipatient.presentation.patient.PatientControllerGet;


class PatientControllerIntegrationTest {

  @Mock
  private PatientServiceImpl  patientService;
  
  @InjectMocks
  private PatientControllerGet patientController;

    /**
   * Initialisation des mocks avant chaque test.
   */
  @SuppressWarnings("deprecation")
  @BeforeEach
  void setUp(){
    MockitoAnnotations.initMocks(this);
  }
    /**
     * Test pour vérifier le fonctionnement de la méthode getPatientById().
     */

  @Test
  void  testGetAllPatientById(){

    PatientDTO patient = new PatientDTO();
    patient.setPatientId(1L);
    patient.setNom("Ali");
    patient.setPrenom("Saif");
    patient.setSexe("M");
    patient.setDateNaissance(Date.valueOf("1996-06-03"));
    
    // Définir le comportement attendu du service
    when(patientService.lirPatientDTO(1L)).thenReturn(patient);

    // Appeler la méthode du contrôleur
    PatientDTO result = patientController.getPatientById(1L);

    // verifier le resultat 
    assertNotNull(result);
    assertEquals(1L, result.getPatientId());
    assertEquals("Ali", result.getNom());
    assertEquals("Saif", result.getPrenom());
    assertEquals("M", result.getSexe());
    assertEquals(Date.valueOf("1996-06-03"), result.getDateNaissance());



    assert patientController.getPatientById(1L).equals(patient) : "le patient n'est pas trouvé";
  
}

}
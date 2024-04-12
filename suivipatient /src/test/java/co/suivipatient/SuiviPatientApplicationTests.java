package co.suivipatient;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Date;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import co.suivipatient.persistance.entity.Patient;

/**
 * Cette classe contient les tests unitaires pour la classe Patient.
 */
@SpringBootTest
class SuiviPatientApplicationTests {

    /**
     * Teste les méthodes d'accès de la classe Patient.
     */
    @Test
    void testPatient() {
        // Créer un objet Patient fictif pour le test
        Patient patientTest = new Patient();
        patientTest.setNom("Ali");
        patientTest.setPrenom("Saif");
        patientTest.setSexe("Masculin");
        patientTest.setDateNaissance(new Date(96, 9, 1)); // 1996-10-01

        // Obtenir les valeurs du patient
        String nom = patientTest.getNom();
        String prenom = patientTest.getPrenom();
        String sexe = patientTest.getSexe();
        Date dateNaissance = patientTest.getDateNaissance();

        // Vérifier si les valeurs sont correctes
        assertEquals("Ali", nom, "Le nom est incorrect.");
        assertEquals("Saif", prenom, "Le prénom est incorrect.");
        assertEquals("Masculin", sexe, "Le sexe est incorrect.");
        assertEquals(new Date(96, 9, 1), dateNaissance, "La date de naissance est incorrecte.");
    }
}

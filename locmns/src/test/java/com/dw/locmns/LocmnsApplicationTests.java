package com.dw.locmns;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class LocmnsApplicationTests {
	@Autowired
	private WebApplicationContext context;
	private MockMvc mvc;

	@BeforeEach
	public void setup() {
		mvc = MockMvcBuilders
				.webAppContextSetup(context)
				.apply(springSecurity())
				.build();
	}

	@Test //Test que l'utilisateur ne puisse pas récupérer la liste des  locations (uniquement le gestionnaire)
	@WithMockUser(username = "sarah@sarah.com", roles = {"UTILISATEUR"})
	void UtilisateurRecupereListeLocation_reponse403forbidden() throws Exception{
		mvc.perform(get("/liste-locations")).andExpect(status().isForbidden());
	}

	@Test
	@WithMockUser(roles = {"GESTIONNAIRE"})//Test que le gestionnaire récupère la liste des utilisateurs
	void gestionnaireAppelUrlListeUtilisateur_OkAttendu() throws Exception {
		mvc.perform(get("/liste-utilisateurs")).andExpect(status().isOk());
	}


	@Test
	@WithMockUser(username = "sarah@sarah.com", roles = {"UTILISATEUR"})
	void AjoutEditionLocation_reponse403forbidden()throws Exception{
		 mvc.perform(get("/ajoutEditionUtilisateur")).andExpect(status().isForbidden());
		}









	}









package dashboard;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import com.google.gson.Gson;

public class Dashboard {

	
	package GeeksforGeeks.Geeks;




		public static void main(String[] args)
		{
			// Creating object of Organisation
			Organisation org = new Organisation();

			// Converting json to object
			org = getOrganisationObject();

			// Displaying object
			System.out.println(org);
		}

		private static Organisation getOrganisationObject()
		{
			// Storing preprocessed json(Added slashes)
			String OrganisationJson
				= "{\"id\":402,\"name\":\"rr@rr.rr\",\"email\":\"rr@rr.rr\",\"password\":\"rrrr\",\"bloodGroup\":\"A+\",\"totalDonation\":0,\"lastDonation\":\"0\",\"gender\":\"Male\",\"canDonate\":1,\"area\":[\"Dhaka\"]}";

			// Creating a Gson Object
			Gson gson = new Gson();

			// Converting json to object
			// first parameter should be preprocessed json
			// and second should be mapping class
			Organisation organisation
				= gson.fromJson(OrganisationJson,
								Organisation.class);

			// return object
			return organisation;
		}


	}

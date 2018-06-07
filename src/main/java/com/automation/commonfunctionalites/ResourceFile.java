package com.automation.commonfunctionalites;

public class ResourceFile {

	// Get Location Api
			public static String GetLocationApi() {
				String res = "/maps/api/place/nearbysearch/json";

				return res;

			}
	
	// Create Location Api
	public static String createLocationApi() {
		String res = "/maps/api/place/add/json";

		return res;

	}
	// Delete Api
		public static String deleteLocationApi() {
			String res = "/maps/api/place/delete/json";

			return res;

		}

	
}

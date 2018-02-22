package com.company;

import java.util.*;

public class ClipsAssertsHandler {

    // Hashtable storing the answers for each question. Pass in answer to get the vector of assert statements
    private Hashtable<String, Vector<String>> donation_hash = new Hashtable<String, Vector<String>>();
    private Hashtable<String, Vector<String>> charity_size_hash = new Hashtable<String, Vector<String>>();
    private Hashtable<String, Vector<String>> tax_return_hash = new Hashtable<>();
    private Hashtable<String, Vector<String>> religion_hash = new Hashtable<>();
    private Hashtable<String, Vector<String>> sector_preference_hash = new Hashtable<>();

    public boolean initializeHashes() {
        try {

            {   // donation_type
                Vector<String> k_ans = new Vector<>();
                k_ans.add("(assert (nameofvariable (name kind)(cf 1)(true_or_false TRUE)))");
                k_ans.add("(assert (current_question tax_exemption))");

                Vector<String> m_ans = new Vector<>();
                m_ans.add("(assert (nameofvariable (name money)(cf 1)(true_or_false TRUE)))");
                m_ans.add("(assert (current_question tax_exemption))");

                Vector<String> v_ans = new Vector<>();
                v_ans.add("(assert (nameofvariable (name volunteer)(cf 1)(true_or_false TRUE)))");
                v_ans.add("(assert (current_question charity_size))");


                donation_hash.put("k", k_ans);
                donation_hash.put("m", m_ans);
                donation_hash.put("v", v_ans);
            }

            {   // charity_size qn
                Vector<String> s_ans = new Vector<>();
                s_ans.add("(assert (nameofvariable (name small)(cf 0.3)(true_or_false TRUE)))");
                s_ans.add("(assert (current_question religion))");
                Vector<String> m_ans = new Vector<>();
                m_ans.add("(assert (nameofvariable (name medium)(cf 0.3)(true_or_false TRUE)))");
                m_ans.add("(assert (current_question religion))");
                Vector<String> l_ans = new Vector<>();
                l_ans.add("(assert (nameofvariable (name large)(cf 0.3)(true_or_false TRUE)))");
                l_ans.add("(assert (current_question religion))");
                charity_size_hash.put("s", s_ans);
                charity_size_hash.put("m", m_ans);
                charity_size_hash.put("l", l_ans);
            }

            {   // tax_return
                Vector<String> y_ans = new Vector<>();
                y_ans.add("(assert (nameofvariable (name notax)(cf -1)(true_or_false TRUE)))");
                y_ans.add("(assert (current_question charity_size))");
                Vector<String> n_ans = new Vector<>();
                n_ans.add("(assert (nameofvariable (name notax)(cf 0.1)(true_or_false TRUE)))");
                n_ans.add("(assert (current_question charity_size))");
                tax_return_hash.put("y", y_ans);
                tax_return_hash.put("n", n_ans);
            }

            {   // religion
                Vector<String> buddhism_ans = new Vector<>();
                Vector<String> christianity_ans = new Vector<>();
                Vector<String> hinduism_ans = new Vector<>();
                Vector<String> islam_ans = new Vector<>();
                Vector<String> taoism_ans = new Vector<>();
                Vector<String> others_ans = new Vector<>();
                buddhism_ans.add("(assert (nameofvariable (name buddhism)(cf 0.7)(true_or_false TRUE)))");
                buddhism_ans.add("(assert (current_question sector_preference))");
                christianity_ans.add("(assert (nameofvariable (name christianity)(cf 0.8)(true_or_false TRUE)))");
                christianity_ans.add("(assert (current_question sector_preference))");
                hinduism_ans.add("(assert (nameofvariable (name hinduism)(cf 0.7)(true_or_false TRUE)))");
                hinduism_ans.add("(assert (current_question sector_preference))");
                islam_ans.add("(assert (nameofvariable (name islam)(cf 0.9)(true_or_false TRUE)))");
                islam_ans.add("(assert (current_question conclusion))");
                taoism_ans.add("(assert (nameofvariable (name taoism)(cf 0.7)(true_or_false TRUE)))");
                taoism_ans.add("(assert (current_question sector_preference))");
                others_ans.add("(assert (current_question sector_preference))"); // others no effect
                religion_hash.put("b", buddhism_ans);
                religion_hash.put("c", christianity_ans);
                religion_hash.put("h", hinduism_ans);
                religion_hash.put("i", islam_ans);
                religion_hash.put("t", taoism_ans);
                religion_hash.put("o", others_ans);
            }

            {
                // sector_preferences
                Vector<String> arts_heritage_ans = new Vector<>();
                Vector<String> community_ans = new Vector<>();
                Vector<String> education_ans = new Vector<>();
                Vector<String> health_ans = new Vector<>();
                Vector<String> religious_ans = new Vector<>();
                Vector<String> social_welfare_ans = new Vector<>();
                Vector<String> sports_ans = new Vector<>();
                Vector<String> others_ans = new Vector<>();

                arts_heritage_ans.add("(assert (nameofvariable (name arts_heritage)(cf 0.6)(true_or_false TRUE)))");
                arts_heritage_ans.add("(assert (current_question conclusion))");
                community_ans.add("(assert (nameofvariable (name community)(cf 0.6)(true_or_false TRUE)))");
                community_ans.add("(assert (current_question conclusion))");
                education_ans.add("(assert (nameofvariable (name education)(cf 0.6)(true_or_false TRUE)))");
                education_ans.add("(assert (current_question conclusion))");
                health_ans.add("(assert (nameofvariable (name health)(cf 0.6)(true_or_false TRUE)))");
                health_ans.add("(assert (current_question conclusion))");
                religious_ans.add("(assert (nameofvariable (name religious)(cf 0.6)(true_or_false TRUE)))");
                religious_ans.add("(assert (current_question conclusion))");
                social_welfare_ans.add("(assert (nameofvariable (name social_welfare)(cf 0.6)(true_or_false TRUE)))");
                social_welfare_ans.add("(assert (current_question conclusion))");
                sports_ans.add("(assert (nameofvariable (name sports)(cf 0.6)(true_or_false TRUE)))");
                sports_ans.add("(assert (current_question conclusion))");
                others_ans.add("(assert (nameofvariable (name others_sector)(cf 0.6)(true_or_false TRUE)))");
                others_ans.add("(assert (current_question conclusion))");

                sector_preference_hash.put("a", arts_heritage_ans);
                sector_preference_hash.put("c", community_ans);
                sector_preference_hash.put("e", education_ans);
                sector_preference_hash.put("h", health_ans);
                sector_preference_hash.put("r", religious_ans);
                sector_preference_hash.put("sw", social_welfare_ans);
                sector_preference_hash.put("sp", sports_ans);
                sector_preference_hash.put("o", others_ans);
            }



        } catch (MissingResourceException mre) {
            mre.printStackTrace();
            return false;
        }



        return true;
    }

    public Vector<String> getAnswers(String relationAsserted, String theAnswer) {

        switch (relationAsserted) {
            case "donation_type":
                return donation_hash.get(theAnswer);
            case "charity_size":
                return charity_size_hash.get(theAnswer);
            case "tax_exemption":
                return tax_return_hash.get(theAnswer);
            case "religion":
                return religion_hash.get(theAnswer);
            case "sector_preference":
                return sector_preference_hash.get(theAnswer);
            default:

        }
        System.out.println("ERROR: No answers found for this relation! ");
        return null;
    }
}

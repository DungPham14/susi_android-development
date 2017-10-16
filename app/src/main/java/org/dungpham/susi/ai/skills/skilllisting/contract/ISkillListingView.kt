package org.dungpham.susi.ai.skills.skilllisting.contract

import org.dungpham.susi.ai.rest.responses.susi.SkillData

/**
 *
 * Created by chiragw15 on 15/8/17.
 */
interface ISkillListingView {
    fun visibilityProgressBar(boolean: Boolean)
    fun updateAdapter(skills: ArrayList<Pair<String, Map<String, SkillData>>>)
    fun displayError()
}
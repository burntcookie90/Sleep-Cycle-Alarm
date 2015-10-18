package io.dwak.sleepcyclealarm.options

import android.app.Activity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.bindView
import io.dwak.mvp_base.MvpFragment
import io.dwak.sleepcyclealarm.R
import io.dwak.sleepcyclealarm.model.Option
import io.dwak.sleepcyclealarm.view.OptionsView
import kotlin.properties.Delegates

class OptionsFragment : MvpFragment<OptionsPresenterImpl>(), OptionsView {
    val recyclerView : RecyclerView by bindView(R.id.recycler_view)
    var adapter : OptionsAdapter by Delegates.notNull()
    var interactionListener : OptionsFragmentInteractionListener? = null

    public companion object {
        public fun newInstance() : Fragment = OptionsFragment()
    }

    override val presenterClass : Class<OptionsPresenterImpl> = javaClass()

    override fun setView() {
        presenter.view = this
    }

    override fun onAttach(activity : Activity?) {
        super.onAttach(activity)
        if(getActivity() is OptionsFragmentInteractionListener)
            interactionListener = getActivity() as OptionsFragmentInteractionListener
        else
            throw RuntimeException("${getActivity().javaClass.simpleName} must implement OptionsFragmentInteractionListener")
    }

    override fun onCreateView(inflater : LayoutInflater?, container : ViewGroup?, savedInstanceState : Bundle?) : View? {
        return inflater?.inflate(R.layout.fragment_options, container, false)
    }

    override fun onViewCreated(view : View?, savedInstanceState : Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = OptionsAdapter(activity, object: OptionsAdapter.OptionsAdapterListener {
            override fun onAlarmOptionItemSelected(position : Int) = interactionListener?.onAlarmOptionSelected(adapter.optionList.get(position))
        })

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(activity)
        presenter.getOptions()
    }

    override fun onDetach() {
        super.onDetach()
        interactionListener = null
    }

    override fun showOptions(options : List<Option>) {
        options.forEach { adapter.addOption(it) }
    }

    public interface OptionsFragmentInteractionListener {
        fun onAlarmOptionSelected(option : Option)
    }
}
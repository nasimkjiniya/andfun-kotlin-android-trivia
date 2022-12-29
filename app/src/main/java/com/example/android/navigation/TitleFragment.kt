package com.example.android.navigation

import android.os.Bundle
import android.renderscript.ScriptGroup.Binding
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.android.navigation.databinding.FragmentTitleBinding

/**
 * A simple [Fragment] subclass.
 * Use the [TitleFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TitleFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding : FragmentTitleBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_title,container,false)

        setHasOptionsMenu(true)

//        simple way to navigate
//        binding.playButton.setOnClickListener()
//        {
//            Navigation.findNavController(it).navigate(R.id.action_titleFragment2_to_gameFragment)
//        }

//      jetpack short version of navigation
       // binding.playButton.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_titleFragment2_to_gameFragment))

        binding.playButton.setOnClickListener()
        {
            it.findNavController().navigate(TitleFragmentDirections.actionTitleFragment2ToGameFragment())
        }

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.overflow_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }
}
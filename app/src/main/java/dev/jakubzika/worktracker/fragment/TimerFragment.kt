package dev.jakubzika.worktracker.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dev.jakubzika.worktracker.R
import dev.jakubzika.worktracker.extensions.visible
import dev.jakubzika.worktracker.viewmodel.TimerViewModel
import kotlinx.android.synthetic.main.fragment_timer.*
import org.koin.androidx.viewmodel.ext.android.viewModel

private const val TIMER_INIT_TEXT = "00:00:00"

class TimerFragment : Fragment() {

    private val viewModel: TimerViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? = inflater.inflate(R.layout.fragment_timer, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
        initListeners()

        subscribeTimerModel()
    }

    private fun showStart() {
        buttonStart.visible = true
        buttonStop.visible = false
        buttonGroup.visible = false
    }

    private fun showStop() {
        buttonStart.visible = false
        buttonStop.visible = true
        buttonGroup.visible = false
    }

    private fun showContinue() {
        buttonStart.visible = false
        buttonStop.visible = false
        buttonGroup.visible = true
    }

    private fun initView() {
        showStart()
    }

    private fun initListeners() {
        buttonStart.setOnClickListener {
            showStop()
            onStartClicked()
        }
        buttonStop.setOnClickListener {
            showContinue()
            onStopClicked()
        }
        buttonContinue.setOnClickListener {
            showStop()
            onContinueClicked()
        }
        buttonRestart.setOnClickListener {
            showStart()
            onRestartClicked()
        }
        buttonSave.setOnClickListener {
            // TODO - continue to SAVE tracked time
        }
    }

    private fun onStartClicked() {
        viewModel.timerStart()
    }

    private fun onStopClicked() {
        viewModel.timerStop()
    }

    private fun onContinueClicked() {
        // TODO
    }

    private fun onRestartClicked() {
        viewModel.timerReset()
    }

    @SuppressLint("SetTextI18n")
    private fun subscribeTimerModel() {
        viewModel.timeLiveData.observe(viewLifecycleOwner, androidx.lifecycle.Observer {
            timeView.text = "%02d:%02d:%02d".format(it.hours, it.minutes, it.seconds)
        })
    }
}
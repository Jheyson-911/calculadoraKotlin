package pe.edu.upeu.calcupeu

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import pe.edu.upeu.calcupeu.databinding.FragmentSecondBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        var valorAnterior= "";
        var operador = ""

        _binding!!.btnCero.setOnClickListener { _binding!!.resultTxt.setText(_binding!!.resultTxt.text.toString()+"0") }
        _binding!!.btnOne.setOnClickListener { _binding!!.resultTxt.setText(_binding!!.resultTxt.text.toString()+"1") }
        _binding!!.btnTwo.setOnClickListener { _binding!!.resultTxt.setText(_binding!!.resultTxt.text.toString()+"2") }
        _binding!!.btnThree.setOnClickListener { _binding!!.resultTxt.setText(_binding!!.resultTxt.text.toString()+"3") }
        _binding!!.btnFour.setOnClickListener { _binding!!.resultTxt.setText(_binding!!.resultTxt.text.toString()+"4") }
        _binding!!.btnFive.setOnClickListener { _binding!!.resultTxt.setText(_binding!!.resultTxt.text.toString()+"5") }
        _binding!!.btnSix.setOnClickListener { _binding!!.resultTxt.setText(_binding!!.resultTxt.text.toString()+"6") }
        _binding!!.btnSeven.setOnClickListener { _binding!!.resultTxt.setText(_binding!!.resultTxt.text.toString()+"7") }
        _binding!!.btnEight.setOnClickListener { _binding!!.resultTxt.setText(_binding!!.resultTxt.text.toString()+"8") }
        _binding!!.btnNine.setOnClickListener { _binding!!.resultTxt.setText(_binding!!.resultTxt.text.toString()+"9") }

        _binding!!.btnSuma.setOnClickListener {
            valorAnterior = _binding!!.resultTxt.text.toString()
            _binding!!.resultTxt.setText("")
            operador="+"

        }
        _binding!!.btnResta.setOnClickListener {
            valorAnterior = _binding!!.resultTxt.text.toString()
            _binding!!.resultTxt.setText("")
            operador="-"

        }
        _binding!!.btnMultiply.setOnClickListener {
            valorAnterior = _binding!!.resultTxt.text.toString()
            _binding!!.resultTxt.setText("")
            operador="*"

        }
        _binding!!.btnDivide.setOnClickListener {
            valorAnterior = _binding!!.resultTxt.text.toString()
            _binding!!.resultTxt.setText("")
            operador="/"

        }
        _binding!!.btnClear.setOnClickListener {
            _binding!!.resultTxt.setText("")
        }
        _binding!!.btnPoint.setOnClickListener {
            valorAnterior = _binding!!.resultTxt.text.toString()
            if(!_binding!!.resultTxt.text.toString().contains( ".")){

                _binding!!.resultTxt.setText(valorAnterior+".")
            }


        }
        _binding!!.btnEqual.setOnClickListener {
            when(operador){
                "+"->{
                    var _numActual= _binding!!.resultTxt.text.toString()
                    _binding!!.resultTxt.setText((valorAnterior.toFloat()+_numActual.toFloat()).toString())
                    valorAnterior = "0"
                    operador = ""
                };
                "-"->{
                    var _numActual= _binding!!.resultTxt.text.toString()
                    _binding!!.resultTxt.setText((valorAnterior.toFloat()-_numActual.toFloat()).toString())
                    valorAnterior = "0"
                    operador = ""
                };
                "*"->{
                    var _numActual= _binding!!.resultTxt.text.toString()
                    _binding!!.resultTxt.setText((valorAnterior.toFloat()*_numActual.toFloat()).toString())
                    valorAnterior = "0"
                    operador = ""
                };
                "/"->{
                    var _numActual= _binding!!.resultTxt.text.toString()
                    _binding!!.resultTxt.setText((valorAnterior.toFloat()/_numActual.toFloat()).toString())
                    valorAnterior = "0"
                    operador = ""
                };
            }
        }

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonSecond.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
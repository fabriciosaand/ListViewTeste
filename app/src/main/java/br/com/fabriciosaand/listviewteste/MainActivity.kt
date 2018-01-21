package br.com.fabriciosaand.listviewteste

import android.content.Context
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import br.com.fabriciosaand.listviewteste.model.Parcela

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var listViewParcelas = findViewById<ListView>(R.id.listViewParcelas)

        listViewParcelas.adapter = CustomAdapter(this)
    }

    private class CustomAdapter(context: Context) : BaseAdapter(){

        private val context: Context

        private val parcelas = arrayListOf<Parcela>(

        )

        init {
            this.context = context
            for (i in 1..20){
                parcelas.add(Parcela("Janeiro 20${i}",true))
            }
        }

        override fun getView(position: Int, p1: View?, viewGroup: ViewGroup?): View {

            val layoutInflater = LayoutInflater.from(context)
            var rowMain = layoutInflater.inflate(R.layout.row_main,viewGroup,false)

            if(position % 2 == 0){
                rowMain.setBackgroundColor(Color.parseColor("#e5ecdd"))
            }

            val textViewMesAno = rowMain.findViewById<TextView>(R.id.textViewMesAno)
            val textViewPago = rowMain.findViewById<TextView>(R.id.textViewPagar)
            val imageViewStatus = rowMain.findViewById<ImageView>(R.id.imageViewOk)

            textViewMesAno.text = parcelas[position].mesAno
            textViewPago.visibility = if (parcelas[position].pago) TextView.INVISIBLE else TextView.VISIBLE
            imageViewStatus.setImageResource(R.drawable.abc_btn_check_to_on_mtrl_000)
            return rowMain
        }

        override fun getItem(position: Int): Any {
            return "TESTE"
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return parcelas.size
        }

    }
}

package com.example.guilhermehayashi.maonamassabasico1

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.guilhermehayashi.maonamassabasico1.modelos.Comida
import com.example.guilhermehayashi.maonamassabasico1.modelos.Pessoa
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    /*
    *
    * MutableList<T> representa uma lista de elementos do tipo T.
    *
    * Dinamica:
    *   - O primeiro usuario come a comida 1 e 2, mas não come a comida 3.
    *   - O segundo usuário come a comida 1 e 3, mas não come a comida 2.
    *   - O terceiro usuário come apenas a comida 3.
    *
    * */

    var nome: String = ""
    var pessoas: MutableList<Pessoa> = mutableListOf()
    var comidas: MutableList<Comida> = mutableListOf()


    object companion {
        val nameKey: String = "NOME_DO_USUARIO"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var pessoa1: Pessoa = Pessoa(nome="Luke")//1 e 2
        var pessoa2: Pessoa = Pessoa(nome="Leia")
        var pessoa3: Pessoa = Pessoa(nome="Chewie")
        pessoas.add(Pessoa(nome = "Luke"))
        pessoas.add(Pessoa(nome = "Leia"))
        pessoas.add(Pessoa(nome = "Revan"))

        comidas.add(Comida(nome = "Maçã"))
        comidas.add(Comida(nome = "Banana"))
        comidas.add(Comida(nome = "Pão"))

        botaoMaca.setOnClickListener({
            comeuAlgo(comidas.get(0))
        })

        botaoBanana.setOnClickListener({
            comeuAlgo(comidas.get(1))
        })
        botaoPao.setOnClickListener({
            comeuAlgo(comidas.get(2))
        })
        botaoMudarNome.setOnClickListener({
            /*
            *
            * É dessa forma que iniciamos uma nova Activity.
            *
            * */
            var intent = Intent(this, SegundaActivity::class.java)
            intent.putExtra(MainActivity.companion.nameKey, nome)
            startActivityForResult(intent, 100)
        })

    }


    fun comeuAlgo(comida: Comida) {
        var txt_usr_1: String = ""
        var txt_usr_2: String = ""
        var txt_usr_3: String = ""
        if (comida == comidas.get(0)) {
            txt_usr_2 = "${pessoas.get(1).nome} comeu: ${comida.nome}"
            txt_usr_1 = "${pessoas.get(0).nome} comeu: ${comida.nome}"
        }
        if (comida == comidas.get(1)) {
            txt_usr_1 = "${pessoas.get(0).nome} comeu: ${comida.nome}"
        }
        if (comida == comidas.get(2)) {
            txt_usr_1 = "${pessoas.get(1).nome} comeu: ${comida.nome}"
            txt_usr_3 = "${pessoas.get(2).nome} comeu: ${comida.nome}"
        }
        textoClicou.text = "${txt_usr_1}\n ${txt_usr_2}\n ${txt_usr_3}"
    }

}

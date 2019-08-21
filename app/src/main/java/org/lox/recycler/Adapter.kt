package org.lox.recycler

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast

class Adapter(var mConText: Context, var list: List<Student?>): RecyclerView.Adapter<Adapter.ViewHolder>() {
    override fun onCreateViewHolder(v: ViewGroup, i: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(mConText)
                .inflate(R.layout.list_student, v, false))
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(v: ViewHolder, i: Int) {
        v.bind(list[i])
        v.itemView.setOnClickListener {
            Toast.makeText(mConText, "${list[i]?.print()}", Toast.LENGTH_SHORT).show()
        }
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private var textViewName: TextView = itemView.findViewById(R.id.text_student_name)
        private var textViewScore: TextView = itemView.findViewById(R.id.text_student_score)
        private var textViewStatus: TextView = itemView.findViewById(R.id.text_student_status)

        fun bind(item: Student?){
            itemView.apply {
                textViewName.text = item?.printName()
                textViewScore.text = item?.printScore()
                textViewStatus.text = item?.printStatus()

                if (textViewStatus.text.equals("Fail")){
                    textViewStatus.setTextColor(resources.getColor(R.color.colorRED))
                }
            }
        }

    }


}
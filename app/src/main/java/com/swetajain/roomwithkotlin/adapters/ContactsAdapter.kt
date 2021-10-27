package com.swetajain.roomwithkotlin.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.swetajain.roomwithkotlin.R
import com.swetajain.roomwithkotlin.database.contacts.Contact

class ContactsAdapter : RecyclerView.Adapter<ContactsAdapter.ContactsViewHolder>() {
    private var contactList = emptyList<Contact>()

    class ContactsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvNum: TextView = itemView.findViewById(R.id.tvNum)
        val tvName: TextView = itemView.findViewById(R.id.tvName)
        val tvEmail: TextView = itemView.findViewById(R.id.tvEmail)
        val image: ImageView = itemView.findViewById(R.id.imageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactsViewHolder {
        return ContactsViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.contacts_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ContactsViewHolder, position: Int) {
        val current = contactList[position]
        holder.tvEmail.text = current.email
        holder.tvName.text = current.name
        holder.tvNum.text = current.phone
    }

    override fun getItemCount(): Int {
        return contactList.size
    }

    fun setData(list: List<Contact>) {
        this.contactList = list
        notifyDataSetChanged()
    }
}
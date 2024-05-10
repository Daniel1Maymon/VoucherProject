import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.finalproject.R
import com.example.finalproject.Voucher


class VoucherAdapter(private val context: Context, private val vouchers:List<Voucher>) : BaseAdapter() {
    override fun getCount(): Int {
        return vouchers.size
    }

    override fun getItem(position: Int): Any {
        return vouchers[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
       // Returns a View that displays the data at the specified position in the list

        // 1- Get the voucher object for the current position
        val voucher = getItem(position) as Voucher

        // 2- Inflate Layout:
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        val resultView: View
        if (convertView == null){
            // inflate a new view using layout inflater
            resultView = inflater.inflate(R.layout.voucher_layout, parent, false)
        }else {
            // If convertView is not Null, REUSE IT
            resultView = convertView
        }

        // 2 - Initialize the views
        val companyName: TextView = resultView.findViewById<TextView>(R.id.company_name)
        val voucherSum: TextView = resultView.findViewById<TextView>(R.id.voucher_sum_text)
        val imageView: ImageView = resultView.findViewById<ImageView>(R.id.imageView)

        companyName.text = voucher.companyName
        voucherSum.text = voucher.voucherSum
        imageView.setImageResource(voucher.voucherImage)

        return resultView

    }
}
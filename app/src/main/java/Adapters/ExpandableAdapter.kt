package Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import com.example.expandablelistview.R
import kotlinx.android.synthetic.main.item_child.view.*
import kotlinx.android.synthetic.main.item_group.view.*

class ExpandableAdapter(var titleList: List<String>, var map: HashMap<String, List<String>>) :
    BaseExpandableListAdapter() {
    override fun getGroupCount(): Int = titleList.size

    override fun getChildrenCount(groupPosition: Int): Int {
        return map[titleList[groupPosition]]?.size!!
    }

    override fun getGroup(groupPosition: Int): String {
        return titleList[groupPosition]
    }

    override fun getChild(groupPosition: Int, childPosition: Int): Any {
        return map[titleList[groupPosition]]?.get(childPosition)!!
    }

    override fun getGroupId(groupPosition: Int): Long = groupPosition.toLong()

    override fun getChildId(groupPosition: Int, childPosition: Int): Long = childPosition.toLong()

    override fun hasStableIds(): Boolean = true


    override fun getGroupView(
        groupPosition: Int,
        isExpanded: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View {
        var groupItemView:View
        if (convertView==null){
            groupItemView = LayoutInflater.from(parent?.context).inflate(R.layout.item_group,parent,false)
        }else{
            groupItemView = convertView
        }

        groupItemView.txt_item_group.text = titleList[groupPosition]

        return groupItemView
    }


    override fun getChildView(
        groupPosition: Int,
        childPosition: Int,
        isLastChild: Boolean,
        convertView: View?,
        parent: ViewGroup?
    ): View {
        var childItemView:View
        if (convertView==null){
            childItemView = LayoutInflater.from(parent?.context).inflate(R.layout.item_child,parent,false)
        }else{
            childItemView = convertView
        }
        childItemView.txt_item_child.text = map[titleList[groupPosition]]?.get(childPosition)

        return childItemView
    }

    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean = true


}
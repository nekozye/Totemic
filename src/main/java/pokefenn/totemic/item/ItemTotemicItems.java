package pokefenn.totemic.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import pokefenn.totemic.Totemic;
import pokefenn.totemic.lib.Strings;

public class ItemTotemicItems extends ItemTotemic
{
    public enum Type
    {
        //Can't remove the first enum constant since the indices need to stay the same
        @Deprecated _unused, iron_bells;
    }

    public ItemTotemicItems()
    {
        super("");
        setRegistryName(Strings.SUB_ITEMS_NAME);
        setHasSubtypes(true);
        setMaxStackSize(64);
        setCreativeTab(Totemic.tabsTotem);
    }


    @Override
    public String getUnlocalizedName(ItemStack itemStack)
    {
        int index = MathHelper.clamp(itemStack.getItemDamage(), 1, Type.values().length - 1);
        return "item." + Strings.RESOURCE_PREFIX + Type.values()[index].toString();
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubItems(CreativeTabs creativeTab, NonNullList<ItemStack> list)
    {
        for(int meta = 1; meta < Type.values().length; ++meta)
            list.add(new ItemStack(this, 1, meta));
    }
}
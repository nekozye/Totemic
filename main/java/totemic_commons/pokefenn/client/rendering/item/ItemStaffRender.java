package totemic_commons.pokefenn.client.rendering.item;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;
import totemic_commons.pokefenn.client.rendering.model.ModelTotemicStaff;
import totemic_commons.pokefenn.lib.Textures;

@SideOnly(Side.CLIENT)
public class ItemStaffRender implements IItemRenderer
{

    private final ModelTotemicStaff modelTotemicStaff;

    public ItemStaffRender()
    {
        modelTotemicStaff = new ModelTotemicStaff();
    }

    @Override
    public boolean handleRenderType(ItemStack item, ItemRenderType type)
    {
        return true;
    }

    @Override
    public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper)
    {
        return true;
    }

    @Override
    public void renderItem(ItemRenderType type, ItemStack item, Object... data)
    {
        switch (type)
        {
            case ENTITY:
            {
                renderTotemicStaff(-0.5F, 0.0F, 0.5F);
                return;
            }
            case EQUIPPED:
            {
                renderTotemicStaff(0.0F, 0.0F, 1.0F);
                return;
            }
            case EQUIPPED_FIRST_PERSON:
            {
                renderTotemicStaff(0.0F, 0.0F, 1.0F);
                return;
            }
            case INVENTORY:
            {
                renderTotemicStaff(0.0F, -0.1F, 1.0F);
                return;
            }
            default:
            {
            }
        }
    }

    private void renderTotemicStaff(float x, float y, float z)
    {
        GL11.glPushMatrix();
        GL11.glDisable(GL11.GL_LIGHTING);

        // Scale, Translate, Rotate
        GL11.glTranslatef(x + 0.3F, y - 0.2F, z - 0.7F);
        GL11.glScalef(0.07F, 0.07F, 0.07F);
        //GL11.glRotatef(240F, 1.5F, 1.5F, 1.5F);


        // Bind texture
        FMLClientHandler.instance().getClient().renderEngine.bindTexture(Textures.TEXTURE_TOTEMIC_STAFF);

        // Render
        modelTotemicStaff.render();

        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glPopMatrix();
    }
}
